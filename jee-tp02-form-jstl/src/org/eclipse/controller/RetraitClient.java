package org.eclipse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Dao.ClientDaoImpl;
import org.eclipse.beans.Client;

/**
 * Servlet implementation class AjoutPersonne
 */
@WebServlet("/retraitClient")
public class RetraitClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetraitClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()); 
		ClientDaoImpl clientDao = new ClientDaoImpl();
		List<Client> clients = clientDao.getAll();
		request.setAttribute("clients", clients);
		request.setAttribute("clientsSize", clients.size());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/retraitClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int num = Integer.valueOf(request.getParameter("num"));
		ClientDaoImpl clientDao = new ClientDaoImpl();
		Client client = clientDao.findById(num);
		if (client ==null) {
			request.setAttribute("num", num);
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreurRetraitClient.jsp").forward(request, response);		
			return;
		}

		request.setAttribute("client", client);
		clientDao.remove(num);
		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmationRetraitClient.jsp").forward(request, response);		
	}

}
