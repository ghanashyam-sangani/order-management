package com.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.entity.Product;
import com.ordermanagement.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@GetMapping("/list")
	public ResponseEntity<?> listProducts() {
		return ResponseEntity.ok(productService.findAll());
	}

}
