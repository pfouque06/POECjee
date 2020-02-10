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
import org.eclipse.forms.AjoutAdresseForm;
import org.eclipse.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Servlet implementation class RetraitAdresse
 */
@WebServlet("/updateAdresse")
public class UpdateAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_CLIENT = "client";
	public static final String ATT_CLIENT_FORM = "cform";
	public static final String ATT_ADRESSE = "adresse";
	public static final String ATT_ADRESSE_FORM = "aform";
	public static final String VUE_SUCCES = "/WEB-INF/confirmationUpdateAdresse.jsp";
	public static final String VUE_FAILED = "/WEB-INF/erreurUpdateAdresse.jsp";
	public static final String VUE_FORM = "/WEB-INF/updateAdresse.jsp";
	
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
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
        //AdresseDao adresseDao = new AdresseDao(session);
        //List<Adresse> adresses = adresseDao.getAll();
        //request.setAttribute("adresses", adresses);
        //request.setAttribute("adressesSize", adresses.size());
		
        //ClientDao clientDao = new ClientDao(session);
		//List<Client> clients = clientDao.getAll();
		//request.setAttribute("clients", clients);
		//request.setAttribute("clientsSize", clients.size());
		
		// check if ID is provided as parameter
		if ( request.getParameter("id").isEmpty()) {
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
			return;
		}
		
		// validation Adresse by ID
		int id = Integer.valueOf(request.getParameter("id"));
		//Session session = HibernateUtil.getSessionFactory().openSession();
		AdresseDao adresseDao = new AdresseDao(HibernateUtil.getSessionFactory().openSession());
		Adresse adresse = adresseDao.findById(id);
		if (adresse ==null) {
			//request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);		
			return;
		}
		
		// regenerate Formulaire adresse
		request.setAttribute("idSaisi", adresse.getId());
		request.setAttribute("rueSaisi", adresse.getRue());
		request.setAttribute("codePostalSaisi", adresse.getCodePostal());
		request.setAttribute("villeSaisi", adresse.getVille());
		
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
		// get and validate client ID
		String id = request.getParameter("id");
		if (!id.matches("[0-9]*"))
			aform.setErreur("id", "Le champ ID ne peut contenir que des chiffres.");

		// Ajout du bean et de l'objet métier à l'objet requête
		request.setAttribute(ATT_ADRESSE, adresse);
		request.setAttribute(ATT_ADRESSE_FORM, aform);

		if (! aform.getErreurs().isEmpty() ) {
			// regenerate Formulaire adresse
			request.setAttribute("idSaisi", id);
			request.setAttribute("rueSaisi", adresse.getRue());
			request.setAttribute("codePostalSaisi", adresse.getCodePostal());
			request.setAttribute("villeSaisi", adresse.getVille());
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
			return;
		}
		
		// validation is OK, persist adresse
		Session session = HibernateUtil.getSessionFactory().openSession();
        AdresseDao adresseDao = new AdresseDao(session);
		Adresse insertedAdresse = adresseDao.findById(Integer.valueOf(id));
		if ( insertedAdresse == null ) {
			request.setAttribute("numSaisi", id);
			this.getServletContext().getRequestDispatcher(VUE_FAILED).forward(request, response);		
			return;
		}
		
		try {
			// Adresse update
			insertedAdresse.setRue(adresse.getRue());
			insertedAdresse.setCodePostal(adresse.getCodePostal());
			insertedAdresse.setVille(adresse.getVille());
			adresseDao.update(insertedAdresse);
			request.setAttribute("adresse", insertedAdresse);
			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);	
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			throw new ServletException(ex);
		}
	}

}
