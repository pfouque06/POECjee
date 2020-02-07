package org.eclipse.beans;

import java.io.Serializable;

public class Personne implements Serializable { //classe public et non final

	private int num; // tous les attributs/champs sont private
	private String nom;
	private String prenom;

	
	public Personne() { // un constructeur public sans parametres
		super();
	}

	public Personne(int num, String nom, String prenom) {
		// TODO Auto-generated constructor stub
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
	}

	// des gettes/setters (mutateurs) pour tous les attributs/champs
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [" + num + "] " + nom + " " + prenom;
	}
	
	
}