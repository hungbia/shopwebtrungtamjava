package com.hungbia.shopweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungbia.shopweb.dao.ProductDao;
import com.hungbia.shopweb.entity.Category;
import com.hungbia.shopweb.entity.Product;
import com.hungbia.shopweb.model.ProductDTO;
import com.hungbia.shopweb.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public void add(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setImage(productDTO.getImage());
		product.setPrice(productDTO.getPrice());
		product.setDesciption(productDTO.getDesciption());
		// set product thuộc về category nào có thể dùng Productdao set id
		Category category = new Category();
		category.setId(productDTO.getCategoryID());

		productDao.add(product);

	}

	@Override
	public void update(ProductDTO productDTO) {
		Product product = new Product();
		product = productDao.getId(productDTO.getId());

		// sd beanUtil de coppy thuoc tinh
		BeanUtils.copyProperties(productDTO, product);

		Category category = new Category();
		category.setId(productDTO.getCategoryID());

		productDao.update(product);

	}

	@Override
	public void delete(ProductDTO productDTO) {
		Product product = productDao.getId(productDTO.getId());
		if (product != null) {
			productDao.delete(product);
		}

	}

	@Override
	public List<ProductDTO> searchNameProdctDTO(String name) {
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		List<Product> products = new ArrayList<Product>();
		products = productDao.searchNameProduct(name);
		for (Product product : products) {
			ProductDTO dto = new ProductDTO();
			dto.setId(product.getId());
			dto.setName(product.getName());
			dto.setImage(product.getImage());
			dto.setPrice(product.getPrice());
			dto.setDesciption(product.getDesciption());
			dto.setCategoryID(product.getCategory().getId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ProductDTO> searchpriceProdctDTO(String priceStart, String priceEnd, int start, int end) {
		List<Product> products = new ArrayList<Product>();
		products = productDao.searchpriceProdctDTO(priceStart, priceEnd, start, end);
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO dto = new ProductDTO();
			dto.setId(product.getId());
			dto.setName(product.getName());
			dto.setImage(product.getImage());
			dto.setPrice(product.getPrice());
			dto.setDesciption(product.getDesciption());
			// diung lazy load hibernate
			dto.setCategoryID(product.getCategory().getId());
			dtos.add(dto);

		}

		return dtos;
	}
}
