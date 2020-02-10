package org.eclipse.Dao;

import org.eclipse.beans.Adresse;
import org.hibernate.Session;

public class AdresseDao extends GenericDao<Adresse, Integer> {
	public AdresseDao(Session session) {
		super(Adresse.class, session);
	}
}
