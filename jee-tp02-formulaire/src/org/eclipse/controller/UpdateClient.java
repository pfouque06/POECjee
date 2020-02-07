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
@WebServlet("/updateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClient() {
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/updateClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int num = Integer.valueOf(request.getParameter("num"));
		request.setAttribute("num", num);
		ClientDaoImpl clientDao = new ClientDaoImpl();
		Client client = clientDao.findById(num);
		if (client ==null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreurUpdateClient.jsp").forward(request, response);		
			return;
		}
		// client
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		// Client validation
		if (nom.trim().isEmpty() ||
			prenom.trim().isEmpty() ||
			telephone.trim().isEmpty() ) { // impossible de créer un client
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreurUpdateClient.jsp").forward(request, response);		
			return;
		}
		// client update
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setTelephone(telephone);
		Client insertedClient = clientDao.update(client);
		request.setAttribute("client", insertedClient);
		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmationUpdateClient.jsp").forward(request, response);		
	}

}
