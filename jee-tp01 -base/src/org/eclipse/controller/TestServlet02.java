package org.eclipse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.beans.Personne;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/mapage02")
public class TestServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().print("Hello World !!");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset=\"utf-8\" />");
//		out.println("<title>Projet JEE</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("Hello World !!");
//		out.println("</body>");
//		out.println("</html>");
		
//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		PrintWriter out = response.getWriter();
//		out.println("Ceci est mapage02");
//		out.println("Hello " + prenom + " " + nom);
		
		String ville = "Nice";
		request.setAttribute("maVille", ville);
		
		Personne perso1 = new Personne();
		perso1.setNom("Deeper");
		perso1.setPrenom("John");
		perso1.setNum(100);
		request.setAttribute("perso1", perso1);
		
		ArrayList<String> sport = new ArrayList<>();
		sport.add("hockey");
		sport.add("football");
		sport.add("ski");
		sport.add("golf");
		request.setAttribute("sport", sport);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
