package org.eclipse.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
name="findIdByObj",
query="SELECT p FROM User p WHERE p.username = :username and p.password = :password"
)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;

	
	public User() { // un constructeur public sans parametres
		super();
	}

	public User(int id, String username, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	// des gettes/setters (mutateurs) pour tous les attributs/champs
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Personne [" + id + "] " + username + " " + password;
	}
}