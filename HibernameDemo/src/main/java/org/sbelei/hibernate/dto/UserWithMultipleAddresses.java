package org.sbelei.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@GeneratedValue
	private int userId;
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date joindeDate;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESSES",
			joinColumns = @JoinColumn(name="USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> addresses = new ArrayList<Address>();
//	private Set<Address> addresses = new HashSet<Address>();
	
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

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

}
