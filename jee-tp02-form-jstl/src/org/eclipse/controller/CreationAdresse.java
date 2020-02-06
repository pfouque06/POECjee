package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Dao.AdresseDaoImpl;
import org.eclipse.Dao.ClientDaoImpl;
import org.eclipse.beans.Adresse;
import org.eclipse.beans.Client;
import org.eclipse.forms.AjoutAdresseForm;
import org.eclipse.forms.AjoutClientForm;

/**
 * Servlet implementation class CreationAdresse
 */
@WebServlet("/creationAdresse")
public class CreationAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public static final String ATT_CLIENT = "client";
	public static final String ATT_CLIENT_FORM = "cform";
	public static final String ATT_ADRESSE = "adresse";
	public static final String ATT_ADRESSE_FORM = "aform";
	public static final String VUE_SUCCES = "/WEB-INF/confirmationCreationAdresse.jsp";
	public static final String VUE_FORM = "/WEB-INF/creationAdresse.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationAdresse() {
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

		// Traitement du formulaire d'adresse et récupération du bean en résultante
		AjoutAdresseForm aform = new AjoutAdresseForm();
		Adresse adresse = aform.creerAdresse(request);

		// Ajout du bean et de l'objet métier à l'objet requête
		request.setAttribute(ATT_ADRESSE, adresse);
		request.setAttribute(ATT_ADRESSE_FORM, aform);

		// regenerate Formulaire
		request.setAttribute("rueSaisi", adresse.getRue());
		request.setAttribute("codePostalSaisi", adresse.getCodePostal());
		request.setAttribute("villeSaisi", adresse.getVille());

		// Traitement du formulaire de client et récupération du bean en résultante
		AjoutClientForm cform = new AjoutClientForm();
		Client client = cform.creerClient(request);
		int clientID = -1;

		// Ajout du bean et de l'objet métier à l'objet requête
		request.setAttribute(ATT_CLIENT, client);
		request.setAttribute(ATT_CLIENT_FORM, cform);

		// regenerate Formulaire
		request.setAttribute("nomSaisi", client.getNom());
		request.setAttribute("prenomSaisi", client.getPrenom());
		request.setAttribute("telephoneSaisi", client.getTelephone());
				
		if (cform.getErreurs().isEmpty()) {
			// validation is OK, persist client and get new client ID
			ClientDaoImpl personneDao = new ClientDaoImpl();
			Client insertedClient = personneDao.save(client);
			request.setAttribute("client", insertedClient);
			clientID = insertedClient.getNum();
		} else {


			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}
		
		// set previously stored client
		adresse.setClientID(clientID);
		
		if (aform.getErreurs().isEmpty()) {
			// validation is OK, persist adresse
			AdresseDaoImpl adresseDao = new AdresseDaoImpl();
			Adresse insertedAdresse = adresseDao.save(adresse);
			if ( insertedAdresse != null ) 
				request.setAttribute("adresse", insertedAdresse);
			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}
	}
}
