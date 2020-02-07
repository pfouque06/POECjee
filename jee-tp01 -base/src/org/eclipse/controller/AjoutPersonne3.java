package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Dao.PersonneDao;
import org.eclipse.beans.Personne;
import org.eclipse.forms.AjoutPersonneForm;

/**
 * Servlet implementation class AjoutPersonne
 */
@WebServlet("/ajoutPersonne3")
public class AjoutPersonne3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_PERSONNE = "personne";
	public static final String ATT_FORM = "form";
	public static final String VUE_SUCCES = "/WEB-INF/confirmationAjoutPersonne.jsp";
	public static final String VUE_FORM = "/WEB-INF/ajoutPersonne3.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutPersonne3() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		/* Préparation de l'objet formulaire */
		AjoutPersonneForm form = new AjoutPersonneForm();

		/* Traitement de la requête et récupération du bean en résultant */
		Personne personne = form.creerPersonne(request);

		/* Ajout du bean et de l'objet métier à l'objet requête */
		request.setAttribute(ATT_PERSONNE, personne);
		request.setAttribute(ATT_FORM, form);

		if (form.getErreurs().isEmpty()) {
			// validation is OK
			PersonneDao personneDao = new PersonneDao();
			Personne insertedPersonne = personneDao.save(personne);
			request.setAttribute("personne", insertedPersonne);
			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward(request, response);
		} else {

			// regenerate Formulaire
			request.setAttribute("nomSaisi", personne.getNom());
			request.setAttribute("prenomSaisi", personne.getPrenom());
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}


	}

	public void validateString(String s)  throws Exception {
		if (s == null || s.length() < 2)
			throw new Exception("La chaîne doit comporter au moins deux caractères");
		char c = s.charAt(0);
		if (!(c >= 'A' && c <= 'Z'))
			throw new Exception("La chaîne doit commencer par une lettre en majuscule");
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (!(c >= 'a' && c <= 'z')&& !(c >= 'A' && c <= 'Z'))
				throw new Exception("La chaîne ne peut contenir que des lettres");;
		}
	}
}
