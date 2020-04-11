package com.hungbia.shopweb.service;

import java.util.List;

import com.hungbia.shopweb.model.ProductDTO;

public interface ProductService {
	public void add(ProductDTO productDTO);

	public void update(ProductDTO productDTO);

	public void delete(ProductDTO productDTO);

	public List<ProductDTO> searchNameProdctDTO(String name);

	public List<ProductDTO> searchpriceProdctDTO(String priceStart, String priceEnd, int start, int end);

}
