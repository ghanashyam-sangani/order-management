package com.ordermanagement.dto;

import java.util.List;

public class OrderRequest {
	private Long id;
	private String orderNumber;
	private List<OrderProductRequest> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderProductRequest> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProductRequest> products) {
		this.products = products;
	}
}
