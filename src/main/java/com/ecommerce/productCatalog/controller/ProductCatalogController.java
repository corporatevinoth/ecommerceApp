package com.ecommerce.productCatalog.controller;

import java.util.List;

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

	@Autowired
	private ProductCatalogService productCatalogService;

	// Save operation
	@PostMapping("/productCatalogs")
	public ProductCatalog saveProductCatalog(@Valid @RequestBody ProductCatalog productCatalog) {
		return productCatalogService.saveProductCatalog(productCatalog);
	}

	// Read operation
	@GetMapping("/productCatalogs")
	public List<ProductCatalog> fetchProductCatalogList() {
		return productCatalogService.fetchProductCatalogList();
	}

	// Update operation
	@PutMapping("/productCatalogs/{id}")
	public ProductCatalog updateProductCatalog(@RequestBody ProductCatalog productCatalog, @PathVariable("id") Long inventoryId) {
		return productCatalogService.updateProductCatalog(productCatalog, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/productCatalogs/{id}")
	public String deleteProductCatalogById(@PathVariable("id") Long inventoryId) {
		productCatalogService.deleteProductCatalogById(inventoryId);
		return "Deleted Successfully";
	}
}
