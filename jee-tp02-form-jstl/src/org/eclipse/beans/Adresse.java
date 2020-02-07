package org.eclipse.beans;

import java.io.Serializable;

public class Adresse implements Serializable {

	private int num;
	private String rue;
	private String codePostal;
	private String ville;
	private int clientID;

	public Adresse() {
		super();
	}

	public Adresse(int num, String rue, String codePostal, String ville, int clientID) {
		super();
		this.num = num;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.clientID = clientID;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getClientID() {
		return clientID;
	}


	public void setClientID(int clientID) {
		this.clientID = clientID;
	}


	@Override
	public String toString() {
		return "Adresse [" + num + "] rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", clientID="
				+ clientID;
	}

	
	
}