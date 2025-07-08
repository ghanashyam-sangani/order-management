package com.ordermanagement.service;

import com.ordermanagement.dto.OrderProductRequest;
import com.ordermanagement.dto.OrderRequest;
import com.ordermanagement.entity.Order;

public interface OrderService {

	Order saveOrder(OrderRequest request);

	Order editOrder(OrderRequest request);

	void deleteOrder(Long id);

	Order addProductToOrder(Long orderId, OrderProductRequest pr);

	Order removeProductFromOrder(Long orderId, Long orderProductId);

	Order updateVendorForOrderProduct(Long orderId, Long orderProductId, Long newVendorId);

}
