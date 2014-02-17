/**
 * 
 */
package org.migue.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;



/**
 * @author migue
 *
 */
@SuppressWarnings ("unused")

@Entity
@Cacheable
@Cache (usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery (name="UserDetails.byId",query = "from UserDetails where userId = ?") // HQL Query
@NamedNativeQuery (name="UserDetails.byName", query="select * from USER_DETAILS where username = ?", resultClass=UserDetails.class) // native SQL Query
@org.hibernate.annotations.SelectBeforeUpdate // this tells hibernate not to do an update statement if the object has not changed
@Table(name="USER_DETAILS")
public class UserDetails {
	

	private int userId;
	
	private Date joinedDate;
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();



	/**
	 * @return the vehicle
	 * the class "Vehicle" has a member variable called "user"
	 */
//	@OneToMany ( mappedBy="user") 
//	@JoinTable (name="USER_VEHICLE", joinColumns=@JoinColumn (name="USER_ID"), inverseJoinColumns=@JoinColumn (name="VEHICLE_ID")) 
//	@ManyToMany
	@OneToMany (cascade =  CascadeType.PERSIST )
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	/**
	 * @param listOfAddresses the listOfAddresses to set
	 */
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	/**
	 * @return the listOfAdresses
	 */
	
	
	@ElementCollection (fetch=FetchType.LAZY)
	@JoinTable (name="USER_ADDRESS", joinColumns=@JoinColumn (name ="USER_ID") )
//	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
//	@CollectionId (columns= {@Column (name="ADDRESS_ID")}, generator = "hilo-gen", type = @Type (type="java.lang.Long") )
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}


	private String description;
	private String userName;

	
	@Temporal(TemporalType.DATE)
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Lob
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	public String getUserName() {
		return userName;
	}
	

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
