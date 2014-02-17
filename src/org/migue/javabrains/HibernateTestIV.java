/**
 * 
 */
package org.migue.javabrains;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.migue.javabrains.dto.UserDetails;

/**
 * @author migue
 * Hibernate Tutorial 25, 26, 27, 28 - HQL
 *
 */
public class HibernateTestIV {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();

		String minUserId = "5";
		String userName = "User 9";
//		Query myQuery =  session.createQuery("from UserDetails where userId > :userId and userName = :userName"); 
//		myQuery.setInteger("userId", Integer.parseInt(minUserId));
//		myQuery.setString("userName", userName);
		
//		myQuery.setInteger(0, Integer.parseInt(minUserId));
//		myQuery.setString(1, userName);
		
//		Query myQuery =  session.createQuery("from UserDetails ");
//		Query myQuery =  session.createQuery("from UserDetails ");

		
		//myQuery.setFirstResult(5); // pagination
		//myQuery.setMaxResults(4); // limit the number of records fetched
		
		/* HQL Named Query example */
//		Query myQuery =  session.getNamedQuery("UserDetails.byId"); 
//		myQuery.setInteger(0,2);

		/* SQL Native Named Query Example */
		Query myQuery =  session.getNamedQuery("UserDetails.byName"); 
		myQuery.setString(0,"User 2");
		

		List<UserDetails> users =  (List<UserDetails>) myQuery.list();
		
		System.out.println("Size of the result: " + users.size());
		session.getTransaction().commit();
		session.close();

		for (UserDetails u:users) {
			System.out.println(u.getUserName());
		}
	}

}
