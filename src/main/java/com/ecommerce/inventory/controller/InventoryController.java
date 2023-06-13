package com.ecommerce.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventory.model.Product;
import com.ecommerce.inventory.service.InventoryService;

import jakarta.validation.Valid;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService productService;

	// Save operation
	@PostMapping("/products")
	public Product saveProduct(@Valid @RequestBody Product product) {
		return productService.saveProduct(product);
	}

	// Read operation
	@GetMapping("/products")
	public List<Product> fetchProductList() {
		return productService.fetchProductList();
	}

	// Update operation
	@PutMapping("/products/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long inventoryId) {
		return productService.updateProduct(product, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/products/{id}")
	public String deleteProductById(@PathVariable("id") Long inventoryId) {
		productService.deleteProductById(inventoryId);
		return "Deleted Successfully";
	}
}
