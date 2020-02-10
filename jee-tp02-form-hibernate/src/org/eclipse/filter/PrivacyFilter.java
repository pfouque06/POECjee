package org.eclipse.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PrivacyFilter
 */
@WebFilter("/*")
public class PrivacyFilter implements Filter {

	// const
	public static final String VUE_SESSION_EXPIRED = "sessionExpired.jsp";

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Filter>>doFilter()");

		HttpServletRequest req = (HttpServletRequest)  request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		// on récupère le nom de la session
		String username = (String)session.getAttribute("username");
		// on récupère le chemin demandé par l’utilisateur
		String chemin = req.getServletPath();
		// on récupère la méthode HTTP utilisée (GET ou POST)
		String methode = req.getMethod();
		System.out.println("Filter>> path = " + chemin);
		System.out.println("Filter>> method = " + methode);
		
		// allows access if session is started or on following allowed pathes
		if (username != null || 
				chemin.equals("/") || 
				chemin.equals("/index.jsp") || 
				chemin.equals("/sessionExpired.jsp") || 
				chemin.equals("/login") && methode.equals("POST")) {
			
			//found = true;
			if (username != null) {
				// session is started
				System.out.println("Filter>> Session started - username = " + username);
				// session is started, then checking cookie
				Cookie[] cks = req.getCookies();
				if (cks != null) {
					for (Cookie ck : cks) { // String name = ck.getName(); //String value = ck.getValue();
						if (ck.getName().equals("Auth")) {
							System.out.println("Filter>> cookie Auth ["+ck.getValue()+"] still valide");
							
							// reset expiration delay
							ck.setMaxAge(30); // 30 more before expiration
							res.addCookie(ck);
							
							// pass the request along the filter chain
							chain.doFilter(request, response);
							return;
						}
					}
				}
				System.out.println("cookie Auth expired");
				session.invalidate();
				res.sendRedirect(VUE_SESSION_EXPIRED);
				return;
			}
			else 
				System.out.println("Filter>> Session did not started yet");
			// pass the request along the filter chain
			chain.doFilter(request, response);
			return;
		}

		System.out.println("Filter>> access prohibited");
		// redirect to initial context
		res.sendRedirect(req.getContextPath());
				
	}

}
