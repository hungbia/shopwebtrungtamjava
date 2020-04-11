package com.hungbia.shopweb.dao;

import java.util.List;

import com.hungbia.shopweb.entity.Category;

public interface CategoryDao {

	public void add(Category category);

	public void update(Category category);

	public void delete(Category category);

	public List<Category> searchNamecategory(String name);

	public Category getid(int id);

}
