package com.estore.service.order;

import com.estore.domain.order.Order;
import com.estore.domain.product.IProduct;
import com.estore.domain.product.Product;

public interface IOrderDetail {
	public int getId();
	public void setId(int id);
	public int getQuantity();
	public void setQuantity(int quantity);
	public Order getOrder();
	public void setOrder(Order order);
	public Product getProduct();
	public void setProduct(Product product);
}
