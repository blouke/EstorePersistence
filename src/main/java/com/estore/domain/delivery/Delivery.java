package com.estore.domain.delivery;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "DELIVERY")
@NamedQueries({
	@NamedQuery(name="findAllDeliveries", query="SELECT d FROM Delivery d"),
	@NamedQuery(name="findDeliveriesById", query="SELECT d FROM Delivery d WHERE d.id = :id"),
	@NamedQuery(name="findDeliveriesByOrderId", query="SELECT d FROM Delivery d WHERE d.orderId = :orderId"),
	@NamedQuery(name="findDeliveriesByAddressId", query="SELECT d FROM Delivery d WHERE d.addressId = :addressId"),
	@NamedQuery(name="findDeliveriesByScheduledDate", query="SELECT d FROM Delivery d WHERE d.scheduledDate = :date"),
	@NamedQuery(name="findDeliveriesByActualDate", query="SELECT d FROM Delivery d WHERE d.actualDate = :date")
})
	
public class Delivery implements Serializable, IDelivery{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@NotNull @Column (name = "order_id")
	private int orderId;
	@NotNull @Column (name = "promised_date")
	private Date scheduledDate;
	@NotNull @Column (name = "actual_date")
	private Date actualDate;
	@NotNull @Column (name = "address_id")
	private int addressId;
	@NotNull
	private double cost;
	@NotNull
	private int status;
	@NotNull @Column (name = "tracking_url")
	private String trackingUrl;
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getOrderId() {
		return orderId;
	}

	@Override
	public Date getScheduledDate() {
		return scheduledDate;
	}

	@Override
	public Date getActualDate() {
		return actualDate;
	}

	@Override
	public int getAddressId() {
		return addressId;
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getTrackingUrl() {
		return trackingUrl;
	}

	@Override
	public void setOrderId(int id) {
		this.orderId = id;
	}
	
	@Override
	public void setScheduledDate(Date date) {
		this.scheduledDate = date;
	}

	@Override
	public void setActualDate(Date date) {
		this.actualDate = date;
	}

	@Override
	public void setAddressId(int id) {
		this.addressId = id;
	}
	
	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void setTrackingUrl(String url) {
		this.trackingUrl = url;
	}
	
	@Override
    public String toString() {
        return "Delivery{" + "id=" + id + ", order Id=" + orderId + ", scheduled date=" + scheduledDate + ", actual date=" + actualDate + ", address Id=" + addressId + ", cost=" + cost + ", status=" + status + ", tracking url=" + trackingUrl + "}";
    }

}
