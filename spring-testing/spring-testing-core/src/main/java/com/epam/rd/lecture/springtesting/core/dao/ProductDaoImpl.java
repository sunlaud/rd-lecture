package com.epam.rd.lecture.springtesting.core.dao;

import com.epam.rd.lecture.springtesting.core.model.Product;

import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void persist(Product product) {
		em.persist(product);
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}

	@Override
	public Product findById(Integer id) {
		return em.find(Product.class, id);
	}
}
