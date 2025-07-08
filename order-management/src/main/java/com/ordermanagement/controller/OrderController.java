package com.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.dto.OrderProductRequest;
import com.ordermanagement.dto.OrderRequest;
import com.ordermanagement.entity.Order;
import com.ordermanagement.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<Order> create(@RequestBody OrderRequest req) {
		return ResponseEntity.ok(orderService.saveOrder(req));
	}

	@PutMapping("/update")
	public ResponseEntity<Order> update(@RequestBody OrderRequest req) {
		return ResponseEntity.ok(orderService.editOrder(req));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return new ResponseEntity<>("Order deleted successfully!", HttpStatus.OK);
	}

	@PostMapping("/{orderId}/add-product")
	public ResponseEntity<Order> addProduct(@PathVariable Long orderId, @RequestBody OrderProductRequest req) {
		return ResponseEntity.ok(orderService.addProductToOrder(orderId, req));
	}

	@DeleteMapping("/{orderId}/remove-product/{orderProductId}")
	public ResponseEntity<Order> removeProduct(@PathVariable Long orderId, @PathVariable Long orderProductId) {
		return ResponseEntity.ok(orderService.removeProductFromOrder(orderId, orderProductId));
	}

	@PutMapping("/{orderId}/update-vendor/{orderProductId}")
	public ResponseEntity<Order> updateVendor(@PathVariable Long orderId, @PathVariable Long orderProductId,
			@RequestParam Long vendorId) {
		return ResponseEntity.ok(orderService.updateVendorForOrderProduct(orderId, orderProductId, vendorId));
	}
}
