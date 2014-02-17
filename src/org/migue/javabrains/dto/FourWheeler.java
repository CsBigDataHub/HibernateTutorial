/**
 * 
 */
package org.migue.javabrains.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author migue
 *
 */
@SuppressWarnings("unused")



@Entity
//@DiscriminatorValue (value="car" )
public class FourWheeler extends Vehicle {
	
	private String steeringWheel ;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
