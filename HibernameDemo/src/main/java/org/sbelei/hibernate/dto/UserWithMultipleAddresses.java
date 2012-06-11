package org.sbelei.hibernate.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="USER_MULTIPLE")
public class UserWithMultipleAddresses {

	@Override
	public String toString() {
		return "UserWithMultipleAddresses [userId=" + userId + ", userName="
				+ userName + ", joindeDate=" + joindeDate + ", addresses="
				+ addresses + ", description=" + description + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int userId;
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date joindeDate;
	@ElementCollection
	private Set<Address> addresses = new HashSet<Address>();
	
	@Lob
	private String description;

	public UserWithMultipleAddresses() {

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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
