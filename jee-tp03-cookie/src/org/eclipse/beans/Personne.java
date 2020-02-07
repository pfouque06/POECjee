package org.eclipse.beans;

import java.io.Serializable;

public class Personne implements Serializable { //classe public et non final

	private int num; // tous les attributs/champs sont private
	private String username;
	private String password;

	
	public Personne() { // un constructeur public sans parametres
		super();
	}

	public Personne(int num, String username, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.num = num;
		this.username = username;
		this.password = password;
	}

	// des gettes/setters (mutateurs) pour tous les attributs/champs
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Personne [" + num + "] " + username + " " + password;
	}
	
	
}