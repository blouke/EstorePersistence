package com.estore.domain.user;

import java.io.Serializable;

public class UserList implements Serializable 
{
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String userDate;
	private Double groupID;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public Double getGroupID() {
		return groupID;
	}
	public void setGroupID(Double groupID) {
		this.groupID = groupID;
	}
	
}
