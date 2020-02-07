package org.eclipse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Dao.AdresseDaoImpl;
import org.eclipse.Dao.ClientDaoImpl;
import org.eclipse.beans.Adresse;
import org.eclipse.beans.Client;

/**
 * Servlet implementation class RetraitAdresse
 */
@WebServlet("/retraitAdresse")
public class RetraitAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetraitAdresse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		AdresseDaoImpl adresseDao = new AdresseDaoImpl();
		List<Adresse> adresses = adresseDao.getAll();
		request.setAttribute("adresses", adresses);
		request.setAttribute("adressesSize", adresses.size());
		
		ClientDaoImpl clientDao = new ClientDaoImpl();
		List<Client> clients = clientDao.getAll();
		request.setAttribute("clients", clients);
		request.setAttribute("clientsSize", clients.size());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/retraitAdresse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int num = Integer.valueOf(request.getParameter("num"));
		AdresseDaoImpl adresseDao = new AdresseDaoImpl();
		Adresse adresse = adresseDao.findById(num);
		if (adresse ==null) {
			request.setAttribute("num", num);
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreurRetraitAdresse.jsp").forward(request, response);		
			return;
		}

		request.setAttribute("adresse", adresse);
		adresseDao.remove(num);
		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmationRetraitAdresse.jsp").forward(request, response);		

	}

}
