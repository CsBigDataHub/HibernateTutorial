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

/* Hibernate Tutorial 24 - persisting detached objects */
public class HibernateTestIII {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		
		
		session.close(); // the user object is detached from now

		/* we open a new session */
		session = sessionFactory.openSession();
		session.beginTransaction();
		user.setUserName("Updated User Name after session closed");
		session.update(user); // this update the detached object
		session.getTransaction().commit();
		session.close();
		

	}

}
