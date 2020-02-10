package org.eclipse.utils;

import org.eclipse.beans.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		// Hibernate settings equivalent to hibernate.cfg.xml's properties     
//		Properties settings = new Properties();     
//		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/jee04?useSSL=false");     
//		settings.put(Environment.USER, "root");     
//		settings.put(Environment.PASS, "root");
//		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");     
//		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");     
//		settings.put(Environment.HBM2DDL_AUTO, "create-drop");  
//		settings.put(Environment.SHOW_SQL, "true");
//		configuration.setProperties(settings); 
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Client.class);
		configuration.addAnnotatedClass(Adresse.class);
		sessionFactory = configuration.buildSessionFactory();
		return configuration.buildSessionFactory();
	}

	public static void close() {
		sessionFactory.close();
	}
}
