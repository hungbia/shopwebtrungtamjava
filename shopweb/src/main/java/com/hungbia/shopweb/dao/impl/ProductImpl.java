package com.hungbia.shopweb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hungbia.shopweb.dao.ProductDao;
import com.hungbia.shopweb.entity.Product;

@Transactional
@Repository
public class ProductImpl implements ProductDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(Product product) {
		entityManager.persist(product);
	}

	@Override
	public void update(Product product) {
		entityManager.merge(product);

	}

	@Override
	public void delete(Product product) {
		entityManager.remove(product);

	}

	@Override
	public List<Product> searchNameProduct(String name) {
		String hql = "SELECT p FROM Product p where p.name like :param";
		return entityManager.createQuery(hql, Product.class).setParameter("param", "%" + name + "%").getResultList();
	}

	@Override
	public Product getId(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> searchpriceProdctDTO(String priceStart, String priceEnd, int start, int end) {
		String hql = "SELECT p FROM Product p inner join Category c on c.id=p.category.id where p.price between :priceEnd AND :priceEnd";
		return entityManager.createQuery(hql, Product.class).setFirstResult(start).setMaxResults(end).getResultList();
	}

}
