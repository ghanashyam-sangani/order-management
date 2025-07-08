package com.ordermanagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.dto.OrderProductRequest;
import com.ordermanagement.dto.OrderRequest;
import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.OrderProduct;
import com.ordermanagement.repository.OrderProductRepository;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.repository.ProductRepository;
import com.ordermanagement.repository.VendorRepository;
import com.ordermanagement.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private OrderProductRepository orderProductRepository;

	@Override
	public Order saveOrder(OrderRequest request) {
		Order order = new Order();
		order.setOrderNumber(request.getOrderNumber());
		List<OrderProduct> ops = new ArrayList<>();
		for (OrderProductRequest pr : request.getProducts()) {
			OrderProduct op = new OrderProduct();
			op.setOrder(order);
			op.setProduct(productRepository.findById(pr.getProductId()).orElseThrow());
			op.setVendor(vendorRepository.findById(pr.getVendorId()).orElseThrow());
			op.setQuantity(pr.getQuantity());
			ops.add(op);
		}
		order.setOrderProducts(ops);
		return orderRepository.save(order);
	}

	@Override
	public Order editOrder(OrderRequest request) {
		Order order = orderRepository.findById(request.getId()).orElseThrow();
		order.setOrderNumber(request.getOrderNumber());
		order.getOrderProducts().clear();
		for (OrderProductRequest pr : request.getProducts()) {
			OrderProduct op = new OrderProduct();
			op.setOrder(order);
			op.setProduct(productRepository.findById(pr.getProductId()).orElseThrow());
			op.setVendor(vendorRepository.findById(pr.getVendorId()).orElseThrow());
			op.setQuantity(pr.getQuantity());
			order.getOrderProducts().add(op);
		}
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public Order addProductToOrder(Long orderId, OrderProductRequest pr) {
		Order order = orderRepository.findById(orderId).orElseThrow();
		OrderProduct op = new OrderProduct();
		op.setOrder(order);
		op.setProduct(productRepository.findById(pr.getProductId()).orElseThrow());
		op.setVendor(vendorRepository.findById(pr.getVendorId()).orElseThrow());
		op.setQuantity(pr.getQuantity());
		order.getOrderProducts().add(op);
		return orderRepository.save(order);
	}

	@Override
	public Order removeProductFromOrder(Long orderId, Long orderProductId) {
		Order order = orderRepository.findById(orderId).orElseThrow();
		order.getOrderProducts().removeIf(op -> op.getId().equals(orderProductId));
		orderProductRepository.deleteById(orderProductId);
		return orderRepository.save(order);
	}

	@Override
	public Order updateVendorForOrderProduct(Long orderId, Long orderProductId, Long newVendorId) {
		OrderProduct op = orderProductRepository.findById(orderProductId).orElseThrow();
		op.setVendor(vendorRepository.findById(newVendorId).orElseThrow());
		orderProductRepository.save(op);
		return orderRepository.findById(orderId).orElseThrow();
	}
}
