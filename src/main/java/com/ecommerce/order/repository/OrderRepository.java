package com.ecommerce.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

	List<Order>	 findByOrderId(String orderId);

	
 }
