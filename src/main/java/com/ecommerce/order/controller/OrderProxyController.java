package com.ecommerce.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderProxyController {

	private static Logger LOGGER = LoggerFactory.getLogger(OrderProxyController.class);

	private static final String Order_service = "orderService";

	int count = 1;

	@Autowired
	private OrderService orderService;

	// read operation
	@CircuitBreaker(fallbackMethod = "getOrderFallback", name = Order_service)
	@GetMapping("/payment/order/{id}/{frompayment}")
	@Retry(name=Order_service)
	public List<Order> getOrder(@PathVariable("id") String orderId, @PathVariable("frompayment") String fromPayment) {
		return null != fromPayment && fromPayment.equals("true") ? orderService.getOrderByOrderId(orderId)
				: new ArrayList<Order>();
	}

	public String getOrderFallback(Exception e) {
		LOGGER.info("order service is not reachable. fall back method called. Please try again");
		return "This is a fallback method for getOrder";
	}
}
