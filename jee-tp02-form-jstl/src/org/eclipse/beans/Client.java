package org.eclipse.beans;

import java.io.Serializable;

public class Client implements Serializable { // classe public et non final

	private int num; // tous les attributs/champs sont private
	private String nom;
	private String prenom;
	private String telephone;

	public Client() { // un constructeur public sans parametres
		super();
	}

	public Client(int num, String nom, String prenom, String telephone) {
		// TODO Auto-generated constructor stub
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [" + num + "] " + nom + " " + prenom + " " + telephone;
	}

}