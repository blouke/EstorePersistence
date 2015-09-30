package com.estore.domain.delivery;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class DeliveryService implements IDeliveryService{

	private EntityManager em;
	public DeliveryService() {
        em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
    }
	
	@Override
	public void deleteDelivery(int id) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        IDelivery delivery = em.find(Delivery.class, id);
        em.remove(delivery);
        
        tx.commit();	
	}
	
	@Override
	public void saveDelivery(IDelivery delivery) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		IDelivery deliveryToUpdate;
		if (delivery.getId() > 0){
			deliveryToUpdate = em.find(Delivery.class, delivery.getId());
			deliveryToUpdate.setOrderId(delivery.getId());
			deliveryToUpdate.setScheduledDate(delivery.getScheduledDate());
			deliveryToUpdate.setActualDate(delivery.getActualDate());
			deliveryToUpdate.setAddressId(delivery.getAddressId());
			deliveryToUpdate.setCost(delivery.getCost());
			deliveryToUpdate.setStatus(delivery.getStatus());
			deliveryToUpdate.setTrackingUrl(delivery.getTrackingUrl());
		} else {
			deliveryToUpdate = delivery;
		}
		em.persist(deliveryToUpdate);
		
		tx.commit();		
	}
	
	@Override
	public IDelivery getDeliveryById(int id) {
		return (IDelivery) em.createNamedQuery("findDeliveriesById").setParameter("id", id).getSingleResult();
	}
	
	@Override
	public List<IDelivery> getDeliveriesByOrderId(int orderId) {
		return em.createNamedQuery("findDeliveriesByOrderId").setParameter("orderId", orderId).getResultList();
	}
	
	@Override
	public List<IDelivery> getDeliveriesByAddressId(int addressId) {
		return em.createNamedQuery("findDeliveriesByAddressId").setParameter("addressId", addressId).getResultList();
	}
	
	@Override
	public List<IDelivery> getDeliveriesByScheduledDate(Date date) {
		return em.createNamedQuery("findDeliveriesByScheduledDate").setParameter("date", date).getResultList();
	}

	@Override
	public List<IDelivery> getDeliveriesByActualDate(Date date) {
		return em.createNamedQuery("findDeliveriesByActualDate").setParameter("date", date).getResultList();
	}
	
	@Override
	public List<IDelivery> getAllDeliveries() {
		return em.createNamedQuery("findAllDeliveries").getResultList();
	}

}
