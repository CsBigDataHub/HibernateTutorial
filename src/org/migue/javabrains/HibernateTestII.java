package org.migue.javabrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.migue.javabrains.dto.UserDetails;


/* Hibernate Tutorial 22 - Explanation of difference between transient - persistant - detached objects */

public class HibernateTestII {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		
		/* I'm a transient object */
		user.setUserName("Test User");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		
		
		session.save(user);
		/* Now I'm going to be a persistent object */
		
		user.setUserName("Updated User");
		user.setUserName("Updated User Again");
		session.getTransaction().commit();
		
		
		session.close();
		
		/* Now I'm a detached object */
		user.setUserName("Updated User Again after session is closed");

	}

}
