package com.estore.jpa;
import java.util.List;


import com.estore.domain.product.IProduct;
import com.estore.domain.product.IProductService;
import com.estore.domain.product.ProductService;


public class JpaTest { 
	private IProductService productService;
	
    public JpaTest() {
    	productService = new ProductService();
    }
 
    public static void main(String[] args) {
        JpaTest test = new JpaTest();
        System.out.println("GET ALL PRODUCTS");
        test.listProducts();
        System.out.println("GET PRODUCTS BY CATEGORY");
        test.getProductForCategory();
        test.updateProduct(1L);
        System.out.println(".. done");
    }
    
    private void listProducts() {	

    	List<IProduct> resultList = productService.getAllProducts();
    	System.out.println("num of products:" + resultList.size());
    	
    	for(IProduct next :resultList) {
    		System.out.println(next);
    	}     
    }
    
    private void getProductForCategory() {
    	List<IProduct> resultList = productService.getProductsByCategory(1L);
    	System.out.println("num of products:" + resultList.size());
    	
    	for(IProduct next :resultList) {
    		System.out.println(next);
    	}   
    }
    
    private void updateProduct(Long id) {
    	IProduct product = productService.getProductById(id);
    	product.setImage("/images/1.jpg");
    	productService.saveProduct(product);
    }
 
i}
