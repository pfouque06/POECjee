package org.eclipse.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest)  request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		// on récupère le nom de la session
		String nom = (String)session.getAttribute("nom");
		// on récupère le chemin demandé par l’utilisateur
		String chemin = req.getServletPath();
		// on récupère la méthode HTTP utilisée (GET ou POST)
		String methode = req.getMethod();
		
		boolean found = false;
		if (nom != null || chemin.equals("/") || chemin.equals("/index.jsp") || chemin.equals("/first") && methode.equals("POST")) {
			
			found = true;
//			Cookie[] cks = req.getCookies();
//			if (cks != null) {
//				for (Cookie ck : cks) {
//					//String name = ck.getName();
//					//String value = ck.getValue();
//					if (ck.getName().equals("Auth")) {
//						found = true;
//						break;
//					}
//				}
//			}
		}

		if (found) 
			// pass the request along the filter chain
			chain.doFilter(request, response);
		else
			// redirect to initial context
			//res.sendRedirect("/jee-tp04-session/sessionExpired.html");
			res.sendRedirect(req.getContextPath());
				
	}



}
