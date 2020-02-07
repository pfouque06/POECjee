package org.eclipse.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.Dao.PersonneDao;
import org.eclipse.beans.Personne;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE_INDEX = "/index.jsp";
	public static final String VUE_TARGET = "/WEB-INF/first.jsp";

	private PersonneDao personneDao;

	public void init() {
		personneDao = new PersonneDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
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
		this.getServletContext().getRequestDispatcher(VUE_TARGET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Personne personne = new Personne();
		personne.setUsername(username);
		personne.setPassword(password);
		//PrintWriter out = response.getWriter();
		Cookie ck = new Cookie("Auth", username);
		//ck.setMaxAge(60 * 60 * 24); // 24h
		ck.setMaxAge(30); // 30 sec
		if (personneDao.validate(personne)) {
			HttpSession session = request.getSession();
//				 session.setAttribute("id",id);
			response.addCookie(ck);
			session.setAttribute("username", username);
			//response.sendRedirect("gestionCompte.jsp");
			this.getServletContext().getRequestDispatcher(VUE_TARGET).forward(request, response);
		} else {
			HttpSession session = request.getSession();
			// session.setAttribute("user", username);
			response.sendRedirect("index.jsp");
			//this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

}
