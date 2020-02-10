package org.eclipse.Dao;

import org.eclipse.beans.Client;
import org.hibernate.Session;

public class ClientDao extends GenericDao<Client, Integer> {
	public ClientDao(Session session) {
		super(Client.class, session);
	}
}
