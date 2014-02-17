package org.migue.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@SuppressWarnings("unused")



@Entity
@Inheritance (strategy = InheritanceType.JOINED)
//@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn (name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Vehicle {

	private int vehicleId;
	private String vehicleName;
	private Collection<UserDetails> userList = new ArrayList<UserDetails>();
	
//	@ManyToOne 
//	@NotFound (action=NotFoundAction.IGNORE) // the user may be null and no exception is thrown
//	private UserDetails user;
//	
	
//	/**
//	 * @return the user
//	 */
////	@ManyToOne
//	@JoinColumn (name="USER_ID")
//	public UserDetails getUser() {
//		return user;
//	}
//	/**
//	 * @param user the user to set
//	 */
//	public void setUser(UserDetails user) {
//		this.user = user;
//	}
//	/**
//	 * @return the vehicleId
//	 */
	
	

	@ManyToMany (mappedBy="vehicles" )
	public Collection<UserDetails> getUserList() {
		return userList;
	}

	
	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}
	
	
	@Id
	@GeneratedValue (strategy =GenerationType.AUTO)
	public int getVehicleId() {
		return vehicleId;
	}
	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}
	/**
	 * @param vehicleName the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
