package com.ecommerce.order.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.order.messaging.OrderEventProducer;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderEventProducer orderEventProducer;

	// Save operation

	public Order saveOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		orderEventProducer.publishMessage(savedOrder);
		return savedOrder;

	}

	// Read operation
	public List<Order> fetchOrderList() {
		return (List<Order>) orderRepository.findAll();
	}

	// Update operation
	public Order updateOrder(Order order, Long orderId) {
		Order dbDataObj = orderRepository.findById(orderId).get();

		if (Objects.nonNull(order.getOrderStatus())) {
			dbDataObj.setOrderStatus(order.getOrderStatus());
		}

		if (Objects.nonNull(order.getOrderDate())) {
			dbDataObj.setOrderDate(order.getOrderDate());
		}
		if (Objects.nonNull(order.getOrderType())) {
			dbDataObj.setOrderType(order.getOrderType());
		}

		return orderRepository.save(dbDataObj);
	}

	
	// Delete operation
	public void deleteOrderById(Long orderId) {
		orderRepository.deleteById(orderId);
	}

	public Optional<Order> getOrder(Long orderId) {
		return orderRepository.findById(orderId);
	}

	public List<Order> getOrderByOrderId(String orderId) {
		
		return orderRepository.findByOrderId(orderId);
	}
}
