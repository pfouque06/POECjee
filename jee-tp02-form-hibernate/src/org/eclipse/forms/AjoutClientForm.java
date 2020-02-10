package org.eclipse.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.beans.Client;

public class AjoutClientForm {

	// const variables
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_TELEPHONE = "telephone";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	// Email Regex java
	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public Client creerClient(HttpServletRequest request) {
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String telephone = getValeurChamp(request, CHAMP_TELEPHONE);
		Client client = new Client();

		try {
			validateString(nom, CHAMP_NOM);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		client.setNom(nom);

		try {
			validateString(prenom, CHAMP_PRENOM);
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		client.setPrenom(prenom);

		try {
			validateInteger(telephone, CHAMP_TELEPHONE, 10);
		} catch (Exception e) {
			setErreur(CHAMP_TELEPHONE, e.getMessage());
		}
		client.setTelephone(telephone);

		if (erreurs.isEmpty()) {
			resultat = "Succès de la création du client.";
		} else {
			resultat = "Échec de la création du client.";
		}
		return client;
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	public void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}

	public void validateString(String s, String label) throws Exception {
		if (s != null) {
			if (s.length() < 2)
				throw new Exception("Le champ " + label + " doit contenir au moins 2 caractères.");
			if (!s.matches("[a-zA-Z -]*"))
				throw new Exception(
						"Le champ " + label + " ne peut contenir que des lettres, des espaces ou des tirets");
		} else {
			throw new Exception("Merci d'entrer le champ " + label + ".");
		}
	}

	public void validateInteger(String s, String label, int size) throws Exception {
		if (s != null) {
			if (!s.matches("[0-9]*"))
				throw new Exception("Le champ " + label + " ne peut contenir que des chiffres.");
			if (s.length() < size)
				throw new Exception("Le champ " + label + " doit contenir au moins " + size + " chiffres.");
			if (s.length() > size)
				throw new Exception("Le champ " + label + " doit contenir au plus " + size + " chiffres.");
		} else {
			throw new Exception("Merci d'entrer le champ " + label + ".");
		}
	}

	public void validateEmail(String s, String label) throws Exception {
		if (s != null) {
			if (!s.matches(EMAIL_REGEX)) // matche to EmailL regex
				throw new Exception("Le champ " + label + " ne peut contenir que des chiffres.");
		} else {
			throw new Exception("Merci d'entrer le champ " + label + ".");
		}
	}

}