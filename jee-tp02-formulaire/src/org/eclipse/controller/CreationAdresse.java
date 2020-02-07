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

/**
 * Servlet implementation class CreationAdresse
 */
@WebServlet("/creationAdresse")
public class CreationAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/creationAdresse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//Adresse
		String rue= request.getParameter("rue");
		String ville= request.getParameter("ville");
		String codePostal= request.getParameter("codePostal");
		int ClientID;
		// Adresse validation
		if (rue.trim().isEmpty() ||
				ville.trim().isEmpty() ||
				codePostal.trim().isEmpty() ) { // impossible de créer une adresse
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreurCreationAdresse.jsp").forward(request, response);
			return;
		}
		
		//Client
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		
		// Client validation
		if (nom.trim().isEmpty() ||
			prenom.trim().isEmpty() ||
			telephone.trim().isEmpty() ) { // impossible de créer un client
			ClientID = -1;
		} else {
			// client is instanced
			Client client = new Client();
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setTelephone(telephone);
			
			// Client persist
			ClientDaoImpl personneDao = new ClientDaoImpl();
			Client insertedClient = personneDao.save(client);
			request.setAttribute("client", insertedClient);
			ClientID = insertedClient.getNum();
			//System.out.println(insertedClient);
		}
		
		// Adresse
		Adresse adresse = new Adresse();
		adresse.setRue(rue);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);
		adresse.setClientID(ClientID);
		
		// Adresse Persist
		AdresseDaoImpl adresseDao = new AdresseDaoImpl();
		Adresse insertedAdresse = adresseDao.save(adresse);
		if ( insertedAdresse != null ) 
			request.setAttribute("adresse", insertedAdresse);
		//System.out.println(insertedAdresse);
		
		// call JSP
		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmationCreationAdresse.jsp").forward(request, response);
	}


}
