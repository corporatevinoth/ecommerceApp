package com.ecommerce.order.service;

import java.util.List;

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
	    
	    public Order saveOrder(Order order)
	    {
	        Order savedOrder = orderRepository.save(order);
	        orderEventProducer.publishMessage(savedOrder);
	        return savedOrder;
	        
	    }
	 
	    // Read operation
	     public List<Order> fetchOrderList()
	    {
	        return (List<Order>)
	            orderRepository.findAll();
	    }
	 
	    // Update operation
	    public Order
	    updateOrder(Order order,
	                     Long orderId)
	    {
	 
	        Order existingOrder
	            = orderRepository.findById(orderId)
	                  .get();
	        existingOrder.setProducts(order.getProducts());
	 
	        return orderRepository.save(existingOrder);
	    }
	 
	    // Delete operation
	    public void deleteOrderById(Long orderId)
	    {
	        orderRepository.deleteById(orderId);
	    }
}
