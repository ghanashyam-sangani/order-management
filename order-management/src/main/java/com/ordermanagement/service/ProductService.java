package com.ordermanagement.service;

import java.util.List;

import com.ordermanagement.entity.Product;

public interface ProductService {
	Product save(Product product);

	List<Product> findAll();
}
