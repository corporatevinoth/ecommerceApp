package com.ecommerce.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {
	private static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	// Save operation
	@PostMapping("/order")
	public Order saveOrder(@Valid @RequestBody Order order) {
		LOGGER.info("saveOrder of OrderController");

		return orderService.saveOrder(order);
	}

	// Read operation
	@GetMapping("/order")
	public List<Order> fetchOrderList() {
		LOGGER.info("fetchOrderList of OrderController");
		return orderService.fetchOrderList();
	}
	
	// read operation
	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable("id") Long orderId) {
		LOGGER.info("getOrder of OrderController");
		return orderService.getOrder(orderId).get();
	}
	
	// read operation
	@GetMapping("/orderList/{id}")
	public List<Order> getOrderByOrderId(@PathVariable("id") String orderId) {
		LOGGER.info("getOrderByOrderId of OrderController");
		return orderService.getOrderByOrderId(orderId);
	}
	
	

	// Update operation
	@PutMapping("/order/{id}")
	public Order updateOrder(@RequestBody Order order, @PathVariable("id") Long inventoryId) {
		LOGGER.info("updateOrder of OrderController");
		return orderService.updateOrder(order, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/order/{id}")
	public String deleteOrderById(@PathVariable("id") Long inventoryId) {
		LOGGER.info("deleteOrderById of OrderController");
		orderService.deleteOrderById(inventoryId);
		return "Deleted Successfully";
	}
}
