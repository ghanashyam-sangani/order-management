package com.ordermanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.entity.Product;
import com.ordermanagement.repository.ProductRepository;
import com.ordermanagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
