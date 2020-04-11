package com.hungbia.shopweb.service;

import java.util.List;

import com.hungbia.shopweb.model.CategoryDTO;

public interface CategoryService {
	public void add(CategoryDTO categoryDTO);

	public void update(CategoryDTO categoryDTO);

	public void delete(CategoryDTO categoryDTO);

	public CategoryDTO getId(int id);

	public List<CategoryDTO> searchNameCategoryDTO(String name);

}
