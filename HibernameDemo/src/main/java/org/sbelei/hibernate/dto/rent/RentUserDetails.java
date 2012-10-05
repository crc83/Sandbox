package org.sbelei.hibernate.dto.rent;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RENT_USER")
public class RentUserDetails {
	
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	@OneToMany(mappedBy="user")//see field name in RentVehilce class
	private Collection<RentVehicle> vehicles = new ArrayList<RentVehicle>();

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

	public Collection<RentVehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<RentVehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
