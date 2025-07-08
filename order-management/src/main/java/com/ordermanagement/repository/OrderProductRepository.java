package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
