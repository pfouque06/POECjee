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
 * Servlet implementation class RetraitAdresse
 */
@WebServlet("/deleteAdresse")
public class RetraitAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_CLIENT = "client";
	public static final String ATT_CLIENT_FORM = "cform";
	public static final String ATT_ADRESSE = "adresse";
	public static final String ATT_ADRESSE_FORM = "aform";
	public static final String VUE_SUCCES = "/WEB-INF/confirmationRetraitAdresse.jsp";
	public static final String VUE_FORM = "/WEB-INF/afficherAdresses.jsp";
	
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
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        AdresseDao adresseDao = new AdresseDao(session);
        List<Adresse> adresses = adresseDao.getAll();
        request.setAttribute("adresses", adresses);
        request.setAttribute("adressesSize", adresses.size());
		
        ClientDao clientDao = new ClientDao(session);
		List<Client> clients = clientDao.getAll();
		request.setAttribute("clients", clients);
		request.setAttribute("clientsSize", clients.size());
		
		// check if ID is provided as parameter
		if ( request.getParameter("id").isEmpty()) {
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
			return;
		}
		
		// validation Adresse by ID
		int id = Integer.valueOf(request.getParameter("id"));
		Adresse adresse = adresseDao.findById(id);
		if (adresse ==null) {
			//request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);		
			return;
		}
		
		try {
			// remove adresse
			request.setAttribute("adresse", adresse);
			adresseDao.delete(adresse);
			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}

}
