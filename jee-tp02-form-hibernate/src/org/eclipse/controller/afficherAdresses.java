package org.eclipse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Dao.AdresseDao;
import org.eclipse.Dao.ClientDao;
import org.eclipse.beans.Adresse;
import org.eclipse.beans.Client;
import org.eclipse.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Servlet implementation class listePersonnes
 */
@WebServlet("/afficherAdresses")
public class afficherAdresses extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public static final String VUE_LISTE = "/WEB-INF/afficherAdresses.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public afficherAdresses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
        Session session = HibernateUtil.getSessionFactory().openSession();
        AdresseDao adresseDao = new AdresseDao(session);
		List<Adresse> adresses = adresseDao.getAll();
		request.setAttribute("adresses", adresses);
		request.setAttribute("adressesSize", adresses.size());
		
        ClientDao clientDao = new ClientDao(session);
		List<Client> clients = clientDao.getAll();
		request.setAttribute("clients", clients);
		request.setAttribute("clientsSize", clients.size());
		
		this.getServletContext().getRequestDispatcher(VUE_LISTE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
