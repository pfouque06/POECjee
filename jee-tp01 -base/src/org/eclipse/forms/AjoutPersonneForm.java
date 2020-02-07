package org.eclipse.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.beans.Personne;

public class AjoutPersonneForm {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public Personne creerPersonne(HttpServletRequest request) {
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		Personne personne = new Personne();
		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		personne.setNom(nom);
		try {
			validationPrenom(prenom);
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		personne.setPrenom(prenom);
		if (erreurs.isEmpty()) {
			resultat = "Succès de la création du client.";
		} else {
			resultat = "Échec de la création du client.";
		}
		return personne;
	}

	private void validationNom(String nom) throws Exception {
		validateString(nom, "nom d'utilisateur");
	}

	private void validationPrenom(String prenom) throws Exception {
		validateString(prenom, "prénom d'utilisateur");
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	} /*
		 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
		 * sinon.
		 */

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
	
	public void validateString(String s, String label) throws Exception {
		if (s != null) {
			if (s.length() < 2)
				throw new Exception("Le " + label + " doit contenir au moins 2 caractères.");
			char c = s.charAt(0);
			if (!(c >= 'A' && c <= 'Z'))
				throw new Exception("Le premier caractère du " + label + " doit être en majsucule.");
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z'))
					throw new Exception("Le " + label + " ne peut contenir que des lettres.");
			}
		} else {
			throw new Exception("Merci d'entrer un " + label + ".");
		}
	}

}