package com.estore.domain.order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.estore.service.order.IOrder;
import com.estore.service.order.IOrderService;

public class OrderService implements IOrderService {

	private EntityManager em;
	
	
	public OrderService(){
		em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
	}
	
	@Override
	public void saveOrder(IOrder order) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		IOrder orderToUpdate;
		if ((order.getId() != null) && (order.getId()>0)){
			orderToUpdate = em.find(Order.class, order.getId());
			orderToUpdate.setAmount(order.getAmount());
			orderToUpdate.setCustomerId(order.getCustomerId());
			orderToUpdate.setOrderDate(order.getOrderDate());
			orderToUpdate.setPaymentId(order.getPaymentId());
			orderToUpdate.setStatus(order.getStatus());
			orderToUpdate.setOrderDetails(order.getOrderDetails());
		} else {
			orderToUpdate = order;
		}
		em.persist(orderToUpdate);
		tx.commit();
	}

	@Override
	public void deleteOrder(int orderId) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		IOrder order = em.find(Order.class, orderId);
		em.remove(order);
		tx.commit();
	}

	@Override
	public List<IOrder> getAllOrders() {
		return em.createNamedQuery("findAllOrders").getResultList();
	}

	@Override
	public IOrder findById(int orderId) {
//		return em.createNamedQuery("Order.findById", Order.class).
//				setParameter("id", orderId).getSingleResult();
		return em.find(Order.class, orderId);
	}

}
