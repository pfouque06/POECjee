package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Dao.ClientDao;
import org.eclipse.beans.Client;
import org.eclipse.forms.AjoutClientForm;
import org.eclipse.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Servlet implementation class AjoutPersonne
 */
@WebServlet("/creationClient")
public class CreationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_CLIENT = "client";
	public static final String ATT_FORM = "cform";
	public static final String VUE_SUCCES = "/WEB-INF/confirmationCreationClient.jsp";
	public static final String VUE_FORM = "/WEB-INF/creationClient.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		/* Traitement du formulaire de requête et récupération du bean en résultant */
		AjoutClientForm cform = new AjoutClientForm();
		Client client = cform.creerClient(request);
		
		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute(ATT_CLIENT, client);
		request.setAttribute(ATT_FORM, cform);

		if (!cform.getErreurs().isEmpty()) {
			// regenerate Formulaire
			request.setAttribute("nomSaisi", client.getNom());
			request.setAttribute("prenomSaisi", client.getPrenom());
			request.setAttribute("telephoneSaisi", client.getTelephone());
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
			return;
		} 

		// validation is OK
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			ClientDao clientDao = new ClientDao(session);
			client.setId(clientDao.save(client));
			request.setAttribute("client", client);
			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			throw new ServletException(ex);
		}
	}

}
