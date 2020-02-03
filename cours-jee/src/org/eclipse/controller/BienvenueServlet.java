package org.eclipse.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BienvenueServlet
 */
@WebServlet("/bienvenue")
public class BienvenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int count=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BienvenueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().print("Bienvenue au cours de programmation");
		
		count++;
		
		// Set refresh, autoload time as 5 seconds
//	    response.setIntHeader("BienvenueServlet", 1);
		request.setAttribute("count", count);
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/bienvenue.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
