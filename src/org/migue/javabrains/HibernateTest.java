package org.migue.javabrains;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.migue.javabrains.dto.Address;
import org.migue.javabrains.dto.FourWheeler;
import org.migue.javabrains.dto.TwoWheeler;
import org.migue.javabrains.dto.UserDetails;
import org.migue.javabrains.dto.Vehicle;

@SuppressWarnings ("unused")

public class HibernateTest {

	public static void main(String[] args) {
		
//		UserDetails user = new UserDetails();
		Vehicle genericVehicle = new Vehicle();
		genericVehicle.setVehicleName("Generic vehicle");
		
		FourWheeler kart= new FourWheeler();
		kart.setVehicleName("Kart");
		kart.setSteeringWheel("Kart steering wheel");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Robot steering bike champion handle");
		
		//user.setUserId(1);
//		user.setUserName("migue");
		Address homeDire1 = new Address();
		homeDire1.setCity("Valencia");
		homeDire1.setState("Spain");
		homeDire1.setStreet("Brasil");
		homeDire1.setPincode("46018");

		Address officeDire1 = new Address();
		officeDire1.setCity("Who Knows");
		officeDire1.setState("Bayyyyy");
		officeDire1.setStreet("None");
		officeDire1.setPincode("666");

		Collection<Vehicle> userVehicles = new ArrayList<Vehicle>();
//		userVehicles.add(mainVehicle);
//		userVehicles.add(secondaryVehicle);
//		user.setVehicles(userVehicles);
//		
//		user.getListOfAddresses().add(homeDire1);
//		user.getListOfAddresses().add(officeDire1);
//		user.setJoinedDate(new Date());
//		user.setDescription("Description of the user goes here");

//		mainVehicle.getUserList().add(user);
//		secondaryVehicle.getUserList().add(user);
		
//		UserDetails user2 = new UserDetails();
//		
//		//user.setUserId(1);
//		user2.setUserName("Second User");
//		Address dire2 = new Address();
//		dire2.setCity("Valencia");
//		dire2.setPincode("666");
//		dire2.setState("Spañish");
//		dire2.setStreet("Cabalac");
//		user2.setAddress(dire2);
//		user2.setJoinedDate(new Date());
//		user2.setDescription("Chupitos a 1 €");

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
//		session.save(mainVehicle);
//		session.save(secondaryVehicle);		
		//session.persist(user);
		//session.save(user2);
		session.save(genericVehicle);
		session.save(kart);
		session.save(bike);
		session.getTransaction().commit();
		session.close();
		

		session = sessionFactory.openSession();
		session.beginTransaction();
//		user = (UserDetails) session.get(UserDetails.class, 3);
		
		// Tutorial 21 - CRUD operations loop
//		for (int i=0; i<10;i++) {
//			UserDetails user = new UserDetails();
//			user.setUserName("User " + i);
//			user.setDescription("Auto-generated user for " + i);
//			session.save(user);
//		}
		
		
//		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		
		@SuppressWarnings("unchecked")
		java.util.List<UserDetails> users = (java.util.List<UserDetails>) session.createQuery(
			    "from UserDetails where userName = ?")
			    .setString(0, "User 5")
			    .list();		
		
		
		session.getTransaction().commit();
		
		//System.out.println("HOW MANY ADDRESSES? " + user.getListOfAddresses().size());
		//System.out.println("User name retrieved as " + user.getUserName());
		System.out.println("User fetched: " + users.get(0).getUserName());

		UserDetails user =  users.get(0);
		
		session.beginTransaction();
		user.setUserName("User 5 updated");
		session.getTransaction().commit();
		
		
//		
//		session.beginTransaction();
//		session.delete(user);
//		session.getTransaction().commit();
		
		session.close();

	}

}
