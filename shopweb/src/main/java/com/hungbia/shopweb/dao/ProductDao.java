package com.hungbia.shopweb.dao;

import java.util.List;

import com.hungbia.shopweb.entity.Product;

public interface ProductDao {

	public void add(Product product);

	public void update(Product product);

	public void delete(Product product);

	public List<Product> searchNameProduct(String name);

	public Product getId(int id);

	public List<Product> searchpriceProdctDTO(String priceStart, String priceEnd, int start, int end);

}
