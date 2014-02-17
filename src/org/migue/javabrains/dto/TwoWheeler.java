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
//@DiscriminatorValue (value="bike")
public class TwoWheeler extends Vehicle {
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
	
}
