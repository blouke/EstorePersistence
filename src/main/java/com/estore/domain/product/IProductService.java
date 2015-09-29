package com.estore.domain.product;

import java.util.List;

public interface IProductService {
	void deleteProduct(int productId);

    List<IProduct> getAllProducts();
    
    List<IProduct>getProductsByCategory(Long categoryId);
    
    void saveProduct(IProduct product);
    
    IProduct getProductById(Long id);
}
