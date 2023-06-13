package com.ecommerce.productCatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.productCatalog.model.ProductCatalog;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog,Long> {

	
 }
