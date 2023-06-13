package com.ecommerce.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.order.model.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Product,Long> {

	
 }
