package com.estore.domain.order;

import java.io.Serializable;
import javax.persistence.*;

import com.estore.service.order.IOrder;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
@NamedQueries({
	@NamedQuery(name="Order.findAllOrders", query="SELECT o FROM Order o"),
	@NamedQuery(name="Order.findById", query="SELECT o FROM Order o WHERE o.id = :id")
})
public class Order implements Serializable, IOrder {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double amount;

	@Column(name="customer_id")
	private int customerId;

	@Column(name="order_date")
	private Timestamp orderDate;

	@Column(name="payment_id")
	private int paymentId;

	private String status;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

}