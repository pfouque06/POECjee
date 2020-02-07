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
import org.eclipse.forms.AjoutClientForm;

/**
 * Servlet implementation class AjoutPersonne
 */
@WebServlet("/updateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_CLIENT = "client";
	public static final String ATT_FORM = "cform";
	public static final String VUE_SUCCES = "/WEB-INF/confirmationUpdateClient.jsp";
	public static final String VUE_FAILED = "/WEB-INF/erreurUpdateClient.jsp";
	public static final String VUE_FORM = "/WEB-INF/updateClient.jsp";
	
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

		// check if ID is provided as parameter
		if ( request.getParameter("id").isEmpty()) {
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
			return;
		}

		// validation Client by ID
		int num = Integer.valueOf(request.getParameter("id"));
		Client client = clientDao.findById(num);
		if (client ==null) {
			//request.setAttribute("num", num);
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);		
			return;
		}

		// generate Formulaire </td>
		request.setAttribute("idSaisi", client.getNum());
		request.setAttribute("nomSaisi", client.getNom());
		request.setAttribute("prenomSaisi", client.getPrenom());
		request.setAttribute("telephoneSaisi", client.getTelephone());
		//request.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		// Traitement du formulaire de requête et récupération du bean en résultant */
		AjoutClientForm cform = new AjoutClientForm();
		Client client = cform.creerClient(request);
		// get and validate client ID
		String id = request.getParameter("id");
		if (!id.matches("[0-9]*"))
			cform.setErreur("id", "Le champ ID ne peut contenir que des chiffres.");
		
		// Ajout du bean et de l'objet métier à l'objet requête
		request.setAttribute(ATT_CLIENT, client);
		request.setAttribute(ATT_FORM, cform);

		if (!cform.getErreurs().isEmpty()) {
			// regenerate Formulaire
			request.setAttribute("idSaisi", id);
			request.setAttribute("nomSaisi", client.getNom());
			request.setAttribute("prenomSaisi", client.getPrenom());
			request.setAttribute("telephoneSaisi", client.getTelephone());
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
			return;
		} 

		// validation is OK
		ClientDaoImpl clientDao = new ClientDaoImpl();
		Client insertedClient = clientDao.findById(Integer.valueOf(id));
		if (insertedClient ==null) {
			request.setAttribute("numSaisi", id);
			this.getServletContext().getRequestDispatcher(VUE_FAILED).forward(request, response);		
			return;
		}
		
		// client update
		insertedClient.setNom(client.getNom());
		insertedClient.setPrenom(client.getPrenom());
		insertedClient.setTelephone(client.getTelephone());
		insertedClient = clientDao.update(insertedClient);
		request.setAttribute("client", insertedClient);
		this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);
	}

}
