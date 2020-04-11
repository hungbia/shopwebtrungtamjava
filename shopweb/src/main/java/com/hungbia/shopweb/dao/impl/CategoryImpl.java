package com.hungbia.shopweb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hungbia.shopweb.dao.CategoryDao;
import com.hungbia.shopweb.entity.Category;

@Transactional
@Repository
public class CategoryImpl implements CategoryDao {
	@PersistenceContext
	EntityManager entity;

	@Override
	public void add(Category category) {
		entity.persist(category);

	}

	@Override
	public void update(Category category) {
		entity.merge(category);
	}

	@Override
	public void delete(Category category) {
		entity.remove(category);

	}

	@Override
	public List<Category> searchNamecategory(String name) {
		String hql = "SELECT c FROM Category c where c.name like :param";
		return entity.createQuery(hql, Category.class).setParameter("param", name).getResultList();
	}

	@Override
	public Category getid(int id) {
		return entity.find(Category.class, id);
	}

}
