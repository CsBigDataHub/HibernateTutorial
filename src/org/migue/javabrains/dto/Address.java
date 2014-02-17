/**
 * 
 */
package org.migue.javabrains.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author migue
 *
 */
@Embeddable 
public class Address {
	private String street;
	private String city;
	private String state;
	private String pincode;
	/**
	 * @return the street
	 */
	@Column(name="STREET_NAME")
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	@Column(name="CITY_NAME")
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	@Column(name="STATE_NAME")
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	@Column(name="PIN_CODE")
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
