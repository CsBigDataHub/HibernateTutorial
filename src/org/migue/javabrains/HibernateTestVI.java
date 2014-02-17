/**
 * 
 */
package org.migue.javabrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.migue.javabrains.dto.UserDetails;

/**
 * @author migue
 *
 */
public class HibernateTestVI {

	/**
	 * @param args
	 * Tutorial 32 - Cacheing in Hibernate
	 */
	/* TUTORIAL 32
	 * First Level Cache - Associated with the session.... when the session is closed, there's no 1st level cache (automatically provided by hibernate)
	 * Second Level Cache - It can be associated across diferent sessions, unlike the 1st level cache, wich is attached to the session
	 * 						- It can be across different apps too
	 * 						- It can be across different clusters (databases)
	 * 
	 * 
	 * TUTORIAL 33
	 * Configuring Second Level Cache 
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 4);
		
		/* .........imagine a lot of code here..... */
		
		user.setUserName("Updated user");
		
		// we get the same object, but hibernate don't throw another select since the object is in the session cache
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 4);
		session.getTransaction().commit();
		session.close();

		/* ... but what if we open a new session.... */
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		// this will arise a new query for hibernate, since it's a different session...but only if we limit us to 1st level cache 
		// ... but if we enable the 2nd level cache, hibernate doesn't throw a new select!
		UserDetails user3 = (UserDetails) session.get(UserDetails.class, 4);
		session.getTransaction().commit();
		session.close();

	}

}
