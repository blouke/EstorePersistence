package com.estore.domain.delivery;

import java.util.Date;
import java.util.List;

public interface IDeliveryService {
	
	void deleteDelivery(int id);
    void saveDelivery(IDelivery delivery);
    IDelivery getDeliveryById(int id);
    List <IDelivery> getDeliveriesByOrderId(int orderId);
    List <IDelivery> getDeliveriesByAddressId(int addressId);
    List <IDelivery> getDeliveriesByScheduledDate(Date date);
    List <IDelivery> getDeliveriesByActualDate(Date date);
    List <IDelivery> getAllDeliveries();
    
}
