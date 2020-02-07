package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Dao.PersonneDao;
import org.eclipse.beans.Personne;

/**
 * Servlet implementation class AjoutPersonne
 */
@WebServlet("/ajoutPersonne1")
public class AjoutPersonne1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutPersonne1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutPersonne1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		// start validation
		boolean verifNom = validateString(nom);
		boolean verifPrenom = validateString(prenom);
		if (!verifNom)
			request.setAttribute("nomIncorrect", "format incorrect");
		if (!verifPrenom)
			request.setAttribute("prenomIncorrect","format incorrect");
		if (!verifNom || !verifPrenom){
			// regenerate Formulaire
			request.setAttribute("nomSaisi", nom);
			request.setAttribute("prenomSaisi",prenom);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutPersonne.jsp").forward(request, response);
		}
		else {
			// validation is OK
			Personne personne = new Personne();
			personne.setNom(nom);
			personne.setPrenom(prenom);
			PersonneDao personneDao = new PersonneDao();
			Personne insertedPersonne = personneDao.save(personne);
			request.setAttribute("personne", insertedPersonne);
			this.getServletContext().getRequestDispatcher("/WEB-INF/confirmationAjoutPersonne.jsp").forward(request, response);		
		}
	}

	public boolean validateString(String s) {
		if (s == null || s.length() < 2)
			return false;
		char c = s.charAt(0);
		if (!(c >= 'A' && c <= 'Z'))
			return false;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (!(c >= 'a' && c <= 'z')&& !(c >= 'A' && c <= 'Z'))
			return false;
		}
		return true;
	}
}
