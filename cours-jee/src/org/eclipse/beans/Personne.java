package org.eclipse.beans;

public class Personne {

	private int num;
	private String nom;
	private String prenom;

	
	public Personne() {
		super();
	}

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