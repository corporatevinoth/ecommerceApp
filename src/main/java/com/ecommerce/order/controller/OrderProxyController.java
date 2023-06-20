package com.ecommerce.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;

@RestController
public class OrderProxyController {

	@Autowired
	private OrderService orderService;


	// read operation
	@GetMapping("/payment/order/{id}/{frompayment}")
	public List<Order> getOrder(@PathVariable("id") String orderId, @PathVariable("frompayment") String fromPayment) {
		return null!=fromPayment && fromPayment.equals("true")?orderService.getOrderByOrderId(orderId):new ArrayList<Order>();
	}
}
