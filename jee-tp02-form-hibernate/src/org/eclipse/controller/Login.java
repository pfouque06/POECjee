package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.Dao.UserDao;
import org.eclipse.beans.User;
import org.eclipse.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE_INDEX = "/index.jsp";
	public static final String VUE_TARGET = "/jee-tp02-form-hibernate";

	private UserDao userDao;

	public void init() {
		// instance UserDao
		Session session = HibernateUtil.getSessionFactory().openSession();
		userDao = new UserDao(session);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
		this.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.getServletContext().getRequestDispatcher(VUE_INDEX).forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("Login>>post");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		System.out.println("Login>> user: " + user.getUsername());
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//if (userDao.contains(user)) {
		Integer id = userDao.findIdByObj(user);
		if ( id != null ) {
			System.out.println("Login>> user["+id+"] found");
			session.setAttribute("username", username);
			Cookie ck = new Cookie("Auth", username);
			ck.setMaxAge(30); // 30 sec //ck.setMaxAge(60 * 60 * 24); // 24h
			response.addCookie(ck);
			this.getServletContext().getRequestDispatcher(VUE_INDEX).forward(request, response);
			//response.sendRedirect("gestionCompte.jsp");
		} else {
			System.out.println("Login>> user not found - cannot authenticate");
			response.sendRedirect(VUE_INDEX);
			//this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

}
