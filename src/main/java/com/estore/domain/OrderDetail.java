package com.estore.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDER_DETAIL database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAIL")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailPK id;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	private Order order;

	public OrderDetail() {
	}

	public OrderDetailPK getId() {
		return this.id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}