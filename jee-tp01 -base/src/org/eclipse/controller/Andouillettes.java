package org.eclipse.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Andouillettes
 */
@WebServlet("/andouillettes")
public class Andouillettes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Andouillettes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		String today =  formater.format(new Date());
		request.setAttribute("today", today);
		
		ArrayList<String> saisons = new ArrayList<>();
		saisons.add("Printemps");
		saisons.add("Eté");
		saisons.add("Automne");
		saisons.add("Hiver");
		request.setAttribute("saisons", saisons);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/andouillettes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
