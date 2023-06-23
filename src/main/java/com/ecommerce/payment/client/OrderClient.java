package com.ecommerce.payment.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.ecommerce.payment.model.Order;

@HttpExchange
public interface OrderClient {

	@GetExchange("payment/order/{id}")
	public Order getOrder(@PathVariable("id") Long orderId);
	
	
	@GetExchange("orderList/{id}")
	public List<Order> getOrderByOrderId(@PathVariable("id") String orderId);
		
}
