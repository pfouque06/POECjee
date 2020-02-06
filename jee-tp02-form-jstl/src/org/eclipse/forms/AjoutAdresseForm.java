package org.eclipse.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.beans.Adresse;

public class AjoutAdresseForm {
	private static final String CHAMP_RUE = "rue";
	private static final String CHAMP_CODEPOSTAL = "codePostal";
	private static final String CHAMP_VILLE = "ville";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public Adresse creerAdresse(HttpServletRequest request) {
		String rue = getValeurChamp(request, CHAMP_RUE);
		String codePostal = getValeurChamp(request, CHAMP_CODEPOSTAL);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		Adresse adresse = new Adresse();
		
		try {
			validateString(rue, CHAMP_RUE);
		} catch (Exception e) {
			setErreur(CHAMP_RUE, e.getMessage());
		}
		adresse.setRue(rue);
		
		try {
			validateInteger(codePostal, CHAMP_CODEPOSTAL, 5);
		} catch (Exception e) {
			setErreur(CHAMP_CODEPOSTAL, e.getMessage());
		}
		adresse.setCodePostal(codePostal);
		
		try {
			validateString(ville, CHAMP_VILLE);
		} catch (Exception e) {
			setErreur(CHAMP_VILLE, e.getMessage());
		}
		adresse.setVille(ville);

		if (erreurs.isEmpty()) {
			resultat = "Succès de la création du client.";
		} else {
			resultat = "Échec de la création du client.";
		}
		return adresse;
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
				throw new Exception("Le champ " + label + " doit contenir au moins 2 caractères.");
			if (!s.matches("[a-zA-Z]*"))
				throw new Exception("Le champ " + label + " ne peut contenir que des lettres.");
		} else {
			throw new Exception("Merci d'entrer le champ " + label + ".");
		}
	}

	public void validateInteger(String s, String label, int size) throws Exception {
		if (s != null) {
			if (!s.matches("[0-9]*"))
				throw new Exception("Le champ " + label + " ne peut contenir que des chiffres.");
			if (s.length() < size)
				throw new Exception("Le champ " + label + " doit contenir au moins "+size+" chiffres.");
			if (s.length() > size)
				throw new Exception("Le champ " + label + " doit contenir au plus "+size+" chiffres.");
		} else {
			throw new Exception("Merci d'entrer le champ " + label + ".");
		}
	}
}