package com.estore.domain.user;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable, IUser {
	private static final long serialVersionUID = 1L;

	@Id
	//@Basic(optional = false)
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	private String first_name;
	
	@NotNull
	private String last_name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password_hash;
	
	@NotNull
	private Date create_date;
	
	@NotNull
	@Column(name="GROUP_ID")
	private Long groupID;
	
	/*@JoinColumn(name = "ID", referencedColumnName = "GROUP_ID")
	@ManyToOne(optional = false)
	private UserGroup group;
		
	public UserGroup getGroup() {
		return group;
	}

	public void setGroup(UserGroup group) {
		this.group = group;
	}*/

	@Override
	public Long getID() {
		return id;
	}

	@Override
	public String getFirstName() {
		return first_name;
	}

	@Override
	public String getLastName() {
		return last_name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPasswordHash() {
		return password_hash;
	}

	@Override
	public Date getDateTime() {
		return create_date;
	}

	@Override
	public Long getGroupID() {
		return groupID;
	}

	@Override
	public void setFirstName(String FirstName) {
		this.first_name = FirstName;

	}

	@Override
	public void setLastName(String LastName) {
		this.last_name = LastName;

	}

	@Override
	public void setEmail(String Email) {
		this.email = Email;

	}

	@Override
	public void setPasswordHash(String PasswordHash) {
		this.password_hash = PasswordHash;

	}

	@Override
	public void setDateTime(Date Datetime) {
		this.create_date = Datetime;

	}

	@Override
	public void setGroupID(Long GroupID) {
		this.groupID = GroupID;

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", create_date=" + create_date
				+ ", group_id=" + groupID + "]";
	}

}
