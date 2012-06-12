package org.sbelei.hibernate.dto.rent;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RentVehicle {
	
	@Id
	@GeneratedValue
	private long id;
	private String vehicleName;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private RentUserDetails user;
//	private Collection<UserDetails> users = new ArrayList<UserDetails>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public RentUserDetails getUser() {
		return user;
	}

	public void setUser(RentUserDetails user) {
		this.user = user;
	}

}
