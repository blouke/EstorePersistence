package com.estore.jpa;
import java.util.List;

import javax.persistence.*;
import com.estore.domain.Product;

public class JpaTest {
	private EntityManager manager;
	 
    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Estore");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);
 
        test.listProducts();
 
        System.out.println(".. done");
    }
    
    private void listProducts() {	
		List<Product> resultList = manager.createQuery("Select a From Product a", Product.class).getResultList();
		System.out.println("num of products:" + resultList.size());
		for (Product next : resultList) {
		    System.out.println("next product: " + next);
		}
        
    }
 
}
