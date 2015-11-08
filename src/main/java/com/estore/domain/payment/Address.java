package com.estore.domain.payment;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a"),
	@NamedQuery(name="findAddressById", query="SELECT a FROM Address a WHERE a.id = :id"),
	@NamedQuery(name="findAddressesByUserId", query="SELECT a FROM Address a WHERE a.userId = :id"),
})

public class Address implements Serializable, IAddress {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String city;

	@Column(name="last_updates_sent")
	private Timestamp lastUpdatesSent;

	private String phone;

	private String state;

	@Column(name="street_address")
	private String streetAddress;

	@Column(name="user_id")
	private int userId;

	@Column(name="zip_code")
	private String zipCode;

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getLastUpdatesSent() {
		return this.lastUpdatesSent;
	}

	public void setLastUpdatesSent(Timestamp lastUpdatesSent) {
		this.lastUpdatesSent = lastUpdatesSent;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}