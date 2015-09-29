package com.estore.domain.delivery;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "DELIVERY")
public class Delivery implements Serializable, IDelivery{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	@NotNull @Column (name = "order_id")
	private Long orderId;
	@NotNull @Column (name = "promised_date")
	private Date scheduledDate;
	@NotNull @Column (name = "actual_date")
	private Date actualDate;
	@NotNull @Column (name = "address_id")
	private Long addressId;
	@NotNull
	private Double cost;
	@NotNull
	private Integer status;
	@NotNull @Column (name = "tracking_url")
	private String trackingUrl;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getScheduledDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getActualDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAddressId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer status() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrackingUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScheduledDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActualDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCost(Double cost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(Integer status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrackingUrl(String url) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public String toString() {
        return "Delivery{" + "id=" + id + ", order Id=" + orderId + ", scheduled date=" + scheduledDate + ", actual date=" + actualDate + ", address Id=" + addressId + ", cost=" + cost + ", status=" + status + ", tracking url=" + trackingUrl + "}";
    }

}
