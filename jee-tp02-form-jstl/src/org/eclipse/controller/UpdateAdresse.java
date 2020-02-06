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
@WebServlet("/updateAdresse")
public class UpdateAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdresse() {
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/updateAdresse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int num = Integer.valueOf(request.getParameter("num"));
		request.setAttribute("num", num);
		AdresseDaoImpl adresseDao = new AdresseDaoImpl();
		Adresse adresse = adresseDao.findById(num);
		if (adresse ==null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreurUpdateAdresse.jsp").forward(request, response);		
			return;
		}

		//Adresse
		String rue= request.getParameter("rue");
		String ville= request.getParameter("ville");
		String codePostal= request.getParameter("codePostal");
		System.out.println("1");
		int ClientID;
		// Adresse validation
		if (rue.trim().isEmpty() ||
				ville.trim().isEmpty() ||
				codePostal.trim().isEmpty() ) { // impossible de créer une adresse
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreurUpdateAdresse.jsp").forward(request, response);
			return;
		}
		
		//Client
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		
		System.out.println("2");
		// Client validation
		if (nom.trim().isEmpty() ||
			prenom.trim().isEmpty() ||
			telephone.trim().isEmpty() ) { // impossible de créer un client
			ClientID = -1;
		} else {
			System.out.println("3");
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
			System.out.println(insertedClient);
		}
		
		System.out.println("4");
		// Adresse
		adresse.setRue(rue);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);
		adresse.setClientID(ClientID);
		System.out.println(adresse);
		
		// Adresse Persist
		Adresse insertedAdresse = adresseDao.update(adresse);
		if ( insertedAdresse != null ) 
			request.setAttribute("adresse", insertedAdresse);
		System.out.println(insertedAdresse);
		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmationUpdateAdresse.jsp").forward(request, response);		
	}

}
