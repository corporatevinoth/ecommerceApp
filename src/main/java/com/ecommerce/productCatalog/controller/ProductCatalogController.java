package com.ecommerce.productCatalog.controller;

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

import com.ecommerce.productCatalog.model.ProductCatalog;
import com.ecommerce.productCatalog.service.ProductCatalogService;

import jakarta.validation.Valid;

@RestController
public class ProductCatalogController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProductCatalogController.class);

	@Autowired
	private ProductCatalogService productCatalogService;

	// Save operation
	@PostMapping("/productCatalog")
	public ProductCatalog saveProductCatalog(@Valid @RequestBody ProductCatalog productCatalog) {
		LOGGER.info("saveProductCatalog from ProductCatalogController" );
		return productCatalogService.saveProductCatalog(productCatalog);
	}

	// Read operation
	@GetMapping("/productCatalog")
	public List<ProductCatalog> fetchProductCatalogList() {
		LOGGER.info("fetchProductCatalogList from ProductCatalogController" );

		return productCatalogService.fetchProductCatalogList();
	}

	// Update operation
	@PutMapping("/productCatalog/{id}")
	public ProductCatalog updateProductCatalog(@RequestBody ProductCatalog productCatalog, @PathVariable("id") Long productCatalogId) {
		LOGGER.info("updateProductCatalog from ProductCatalogController" );

		return productCatalogService.updateProductCatalog(productCatalog, productCatalogId);
	}

	// Delete operation
	@DeleteMapping("/productCatalog/{id}")
	public String deleteProductCatalogById(@PathVariable("id") Long productCatalogId) {
		LOGGER.info("deleteProductCatalogById from ProductCatalogController" );

		productCatalogService.deleteProductCatalogById(productCatalogId);
		return "Deleted Successfully";
	}
	
	@GetMapping("/productCatalog/{id}")
	public ProductCatalog getproductCatalog(@PathVariable("id") Long productCatalogId) {
		LOGGER.info("getproductCatalog from ProductCatalogController" );

		return productCatalogService.findByproductCatalogId(productCatalogId).get();
	}
}
