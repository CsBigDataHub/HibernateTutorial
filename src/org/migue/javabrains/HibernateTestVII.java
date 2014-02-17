/**
 * 
 */
package org.migue.javabrains;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.migue.javabrains.dto.UserDetails;

/**
 * @author migue
 *
 */
public class HibernateTestVII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query myQuery = session.createQuery("from UserDetails user where user.userId = 1");
		myQuery.setCacheable(true);
		UserDetails user = (UserDetails) myQuery.list().get(0);
		

		/* ... but what if we open a new session.... */
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query myQuery2 = session.createQuery("from UserDetails user where user.userId = 1");
		UserDetails user2 = (UserDetails) myQuery.list().get(0);
		
		session.getTransaction().commit();
		session.close();
	}

}
