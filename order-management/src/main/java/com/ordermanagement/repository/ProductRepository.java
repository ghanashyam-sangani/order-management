package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
