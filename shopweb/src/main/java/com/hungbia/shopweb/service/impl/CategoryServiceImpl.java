package com.hungbia.shopweb.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungbia.shopweb.dao.CategoryDao;
import com.hungbia.shopweb.entity.Category;
import com.hungbia.shopweb.model.CategoryDTO;
import com.hungbia.shopweb.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;

	@Override
	public void add(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		categoryDao.add(category);

	}

	@Override
	public void update(CategoryDTO categoryDTO) {
		Category category = new Category();
		category = categoryDao.getid(categoryDTO.getId());
		if (category != null) {
			categoryDao.update(category);
		}

	}

	@Override
	public void delete(CategoryDTO categoryDTO) {
		Category category = new Category();
		category = categoryDao.getid(categoryDTO.getId());
		if (category != null) {
			categoryDao.delete(category);
		}

	}

	@Override
	public List<CategoryDTO> searchNameCategoryDTO(String name) {

		return null;
	}

	@Override
	public CategoryDTO getId(int id) {
		Category category = categoryDao.getid(id);
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		return dto;

	}

}
