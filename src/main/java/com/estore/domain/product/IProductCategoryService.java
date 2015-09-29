package com.estore.domain.product;

import java.util.List;

public interface IProductCategoryService {
	void deleteCategory(Long categoryId);

    List<IProductCategory> getAllCategories();
    
    void saveCategory(IProductCategory category);
    
    IProductCategory getCategoryById(Long id);
}
