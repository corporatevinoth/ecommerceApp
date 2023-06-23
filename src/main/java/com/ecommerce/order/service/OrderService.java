package com.ecommerce.order.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.order.messaging.OrderEventProducer;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;

@Service
public class OrderService {


	private static Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderEventProducer orderEventProducer;

	// Save operation

	public Order saveOrder(Order order) {
		LOGGER.info("saveOrder of OrderService" );

		Order savedOrder = orderRepository.save(order);
		orderEventProducer.publishMessage(savedOrder);
		return savedOrder;

	}

	// Read operation
	public List<Order> fetchOrderList() {
		LOGGER.info("fetchOrderList of OrderService" );

		return (List<Order>) orderRepository.findAll();
	}

	// Update operation
	public Order updateOrder(Order order, Long orderId) {
		LOGGER.info("updateOrder of OrderService" );

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
		LOGGER.info("deleteOrderById of OrderService" );

		orderRepository.deleteById(orderId);
	}

	public Optional<Order> getOrder(Long orderId) {
		LOGGER.info("getOrder of OrderService" );

		return orderRepository.findById(orderId);
	}

	public List<Order> getOrderByOrderId(String orderId) {
		LOGGER.info("getOrderByOrderId of OrderService" );

		
		return orderRepository.findByOrderId(orderId);
	}
}
