package org.sbelei.hibernate.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {

	@Id
	private int userId;
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joindeDate;
	@Transient
	private String address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
