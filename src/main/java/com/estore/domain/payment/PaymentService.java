package com.estore.domain.payment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

public class PaymentService implements IPaymentService {
	
	private EntityManager em;

    public PaymentService() {
        em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
    }

	@Override
	public void deletePayment(int paymentId) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        Payment payment = em.find(Payment.class, paymentId);
        em.remove(payment);
        tx.commit();
		
	}

	@Override
	public List<IPayment> getAllPayments() {
		List<IPayment> resultList = em.createQuery("Select a From Payment a", IPayment.class).getResultList();
		return resultList;
	}

	@Override
	public void savePayment(IPayment payment) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        IPayment paymentToUpdate;
        if ((payment.getId() != null) && (payment.getId() > 0)) {
        	paymentToUpdate = em.find(Payment.class, payment.getId());
        	paymentToUpdate.setBillingAddressId(payment.getBillingAddressId());
        	paymentToUpdate.setOrderId(payment.getOrderId());
        	paymentToUpdate.setDate(payment.getDate());
        	paymentToUpdate.setPaymentGateway(payment.getPaymentGateway());
        	paymentToUpdate.setStatus(payment.getStatus());
        	paymentToUpdate.setTransactionNumber(payment.getTransactionNumber());
        } else {
        	paymentToUpdate = payment;
        }

        em.persist(paymentToUpdate);
        tx.commit();
		
	}

	@Override
	public IPayment getPaymentById(Long id) {
		List<IPayment> resultList = em.createQuery("Select a From Payment a Where a.id=:arg1").setParameter("arg1", id).getResultList();
        if (resultList.isEmpty()) return null;
        else if (resultList.size() == 1) return resultList.get(0);
        throw new NonUniqueResultException();
	}
	
	
	@Override
	public void saveAddress(IAddress address){
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(address);
        tx.commit();
	}

}
