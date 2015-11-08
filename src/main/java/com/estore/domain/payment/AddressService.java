package com.estore.domain.payment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.estore.domain.delivery.Delivery;
import com.estore.domain.delivery.IDelivery;



public class AddressService implements IAddressService{

	private EntityManager em;
	public AddressService() {
        em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
    }
	
	public void deleteAddress(int id) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        IAddress address = em.find(Address.class, id);
        em.remove(address);
        tx.commit();		
	}

	public void saveAddress(IAddress address) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		IAddress addressToUpdate;
		if (address.getId() > 0){
			addressToUpdate = em.find(Address.class, address.getId());
			addressToUpdate.setStreetAddress(address.getStreetAddress());
			addressToUpdate.setCity(address.getCity());
			addressToUpdate.setState(address.getState());
			addressToUpdate.setZipCode(address.getZipCode());
			addressToUpdate.setPhone(address.getPhone());

		} else {
			addressToUpdate = address;
		}
		em.persist(addressToUpdate);
		
		tx.commit();		
	}

	public IAddress getAddressById(int id) {
		return (IAddress) em.createNamedQuery("findAddressById").setParameter("id", id).getSingleResult();
	}

	public List<IAddress> getAddressesByUserId(int userId) {
		return em.createNamedQuery("findAddressesByUserId").setParameter("id", userId).getResultList();
	}

	public List<IAddress> getAllAddresses() {
		return em.createNamedQuery("Address.findAll").getResultList();
	}

}
