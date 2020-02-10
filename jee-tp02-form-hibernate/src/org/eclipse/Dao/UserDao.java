package org.eclipse.Dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.eclipse.beans.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao extends GenericDao<User, Integer> {
	public UserDao(Session session) {
		super(User.class, session);
	}
	
	public boolean contains(User user) {
		Transaction tx = session.beginTransaction();
		return session.contains(user);
	}
	
	public Integer findIdByObj(User user) {
		Integer result = null;

		Transaction tx = session.beginTransaction();
//		String sql = "select * from personne where username = :username and password = :password ";
//		SQLQuery sqlQuery = session.createSQLQuery(sql);
//		sqlQuery.addEntity(User.class);
//		sqlQuery.setParameter("username", user.getUsername());
//		sqlQuery.setParameter("password", user.getPassword());
//		List<User> sqlUsers = (List<User>) sqlQuery.list();
		
		Query query = session.getNamedQuery("findIdByObj");
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		List<User> users = (List<User>) query.list();
		
		if ( ! users.isEmpty() )
			result = users.get(0).getId();
		
		tx.commit();
		return result;
	}
}
