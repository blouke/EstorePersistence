package com.estore.domain.payment;

import java.util.List;

import com.estore.domain.payment.IAddress;

public interface IAddressService {
		
		void deleteAddress(int id);
	    void saveAddress(IAddress address);
	    IAddress getAddressById(int id);
	    List <IAddress> getAddressesByUserId(int userId);
	    List <IAddress> getAllAddresses();
	    
	}
