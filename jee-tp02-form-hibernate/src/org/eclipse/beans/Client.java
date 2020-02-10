package org.eclipse.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable { // classe public et non final

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; // tous les attributs/champs sont private
	private String nom;
	private String prenom;
	private String telephone;

	public Client() { // un constructeur public sans parametres
		super();
	}

	public Client(int id, String nom, String prenom, String telephone) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}

	// des gettes/setters (mutateurs) pour tous les attributs/champs
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Client [" + id + "] " + nom + " " + prenom + " " + telephone;
	}

}