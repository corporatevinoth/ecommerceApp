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

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.service.InventoryService;

import jakarta.validation.Valid;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	// Save operation
	@PostMapping("/inventory")
	public Inventory saveInventory(@Valid @RequestBody Inventory Inventory) {
		return inventoryService.saveInventory(Inventory);
	}

	// Read operation
	@GetMapping("/inventory")
	public List<Inventory> fetchInventoryList() {
		return inventoryService.fetchInventoryList();
	}
	
	@GetMapping("/inventory/{id}")
	public Inventory getInventory(@PathVariable("id") Long inventoryId) {
		return inventoryService.findByInventoryId(inventoryId).get();
	}

	// Update operation
	@PutMapping("/inventory/{id}")
	public Inventory updateInventory(@RequestBody Inventory Inventory, @PathVariable("id") Long inventoryId) {
		return inventoryService.updateInventory(Inventory, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/inventory/{id}")
	public String deleteInventoryById(@PathVariable("id") Long inventoryId) {
		inventoryService.deleteInventoryById(inventoryId);
		return "Deleted Successfully";
	}
}
