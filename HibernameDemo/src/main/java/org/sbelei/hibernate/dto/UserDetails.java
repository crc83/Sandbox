package org.sbelei.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sbelei.hibernate.dto.addreses.Address;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", joindeDate=" + joindeDate + ", address=" + getAddress()
				+ ", description=" + description + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int userId;
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date joindeDate;
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name = "city", column = @Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name = "state", column = @Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name = "pincode", column = @Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	private Address officeAddress;
	
	@Lob
	private String description;

	public UserDetails() {

	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName+" from getter";
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoindeDate() {
		return joindeDate;
	}

	public void setJoindeDate(Date joindeDate) {
		this.joindeDate = joindeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return homeAddress;
	}

	public void setAddress(Address address) {
		this.homeAddress = address;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

}
