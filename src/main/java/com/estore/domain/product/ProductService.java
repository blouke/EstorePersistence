package com.estore.domain.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

public class ProductService implements IProductService {
	
	private EntityManager em;

    public ProductService() {
        em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
    }

	@Override
	public void deleteProduct(int productId) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        Product product = em.find(Product.class, productId);
        em.remove(product);
        tx.commit();
		
	}

	@Override
	public List<IProduct> getAllProducts() {
		List<IProduct> resultList = em.createQuery("Select a From Product a", IProduct.class).getResultList();
		return resultList;
	}

	@Override
	public List<IProduct> getProductsByCategory(Long categoryId) {
		List<IProduct> resultList = em.createQuery("Select a From Product a Where a.categoryId=:arg1", IProduct.class).setParameter("arg1", categoryId).getResultList();
		return resultList;
	}

	@Override
	public void saveProduct(IProduct product) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        IProduct productToUpdate;
        if ((product.getId() != null) && (product.getId() > 0)) {
            productToUpdate = em.find(Product.class, product.getId());
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setCategoryId(product.getCategoryId());
            productToUpdate.setImage(product.getImage());
        } else {
            productToUpdate = product;
        }

        em.persist(productToUpdate);
        tx.commit();
		
	}

	@Override
	public IProduct getProductById(Long id) {
		List<IProduct> resultList = em.createQuery("Select a From Product a Where a.id=:arg1").setParameter("arg1", id).getResultList();
        if (resultList.isEmpty()) return null;
        else if (resultList.size() == 1) return resultList.get(0);
        throw new NonUniqueResultException();
	}

}
