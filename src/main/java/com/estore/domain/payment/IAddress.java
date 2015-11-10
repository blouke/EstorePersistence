package com.estore.domain.payment;

import com.estore.domain.user.User;

public interface IAddress {
	public int getId();
	public String getCity();
	public void setCity(String city);
	public String getPhone();
	public void setPhone(String phone);
	public String getState();
	public void setState(String state);
	public String getStreetAddress();
	public void setStreetAddress(String streetAddress);
	public String getZipCode();
	public void setZipCode(String zipCode);
	public User getUser();
	public void setUser(User user);
}
