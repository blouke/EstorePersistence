package com.estore.domain.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

public class ProductCategoryService implements IProductCategoryService {
	
	private EntityManager em;

    public ProductCategoryService() {
        em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
    }

	@Override
	public void deleteCategory(Long categoryId) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        ProductCategory category = em.find(ProductCategory.class, categoryId);
        em.remove(category);
        tx.commit();
	}

	@Override
	public List<IProductCategory> getAllCategories() {
		List<IProductCategory> resultList = em.createQuery("Select a From ProductCategory a", IProductCategory.class).getResultList();
		return resultList;
	}

	@Override
	public void saveCategory(IProductCategory category) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        IProductCategory categoryToUpdate;
        if ((category.getId() != null) && (category.getId() > 0)) {
        	categoryToUpdate = em.find(ProductCategory.class, category.getId());
        	categoryToUpdate.setName(category.getName());
            categoryToUpdate.setDescription(category.getDescription());
        } else {
            categoryToUpdate = category;
        }

        em.persist(categoryToUpdate);
        tx.commit();
	}

	@Override
	public IProductCategory getCategoryById(Long id) {
		List<IProductCategory> resultList = em.createQuery("Select a From ProductCategory a Where a.id=:arg1").setParameter("arg1", id).getResultList();
        if (resultList.isEmpty()) return null;
        else if (resultList.size() == 1) return resultList.get(0);
        throw new NonUniqueResultException();
	}

	

}
