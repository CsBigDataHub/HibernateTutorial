/**
 * 
 */
package org.migue.javabrains;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.migue.javabrains.dto.UserDetails;

/**
 * @author migue
 * Hibernate Tutorial - 29 (Introduction to Criteria API)
 * 						30 (Understanding Criteria)
 *						31 (Projections and Query by Example)
 */
public class HibernateTestV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();

		
//		Criteria myCriteria = session.createCriteria(UserDetails.class);
		
		/* for "and" clauses */
//		myCriteria.add(Restrictions.like("userName", "%User 9"))
//					.add(Restrictions.between("userId", 5, 50));
		
		/* for "or" clauses */
//		myCriteria.add(Restrictions.or(Restrictions.like("userName", "%User 9"), Restrictions.between("userId", 5, 50))  );
//		List<UserDetails> users =  (List<UserDetails>) myCriteria.list();
		
		
//		Criteria myCriteria = session.createCriteria(UserDetails.class).
//							setProjection(Projections.max("userId")).
//								addOrder(Order.asc("userId"));
//
		

		
		
		/* Adding projections...*/
//		Criteria myCriteria = session.createCriteria(UserDetails.class).
//					addOrder(Order.desc("userId"));

		UserDetails exampleUser = new UserDetails();
		//exampleUser.setUserId(5); // NOTE! Hibernates ignores the PK and null properties
		exampleUser.setUserName("like User%");
		
		Example example = Example.create(exampleUser);
		
		/* Querying by example... */
		Criteria myCriteria = session.createCriteria(UserDetails.class).add(example);
		
		List<UserDetails> users =  (List<UserDetails>) myCriteria.list();
		System.out.println("Size of the result: " + users.size());
		session.getTransaction().commit();
		session.close();

		for (UserDetails u:users) {
			System.out.println(u.getUserName());
		}
	}


}
