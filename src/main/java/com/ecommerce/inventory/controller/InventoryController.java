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
	private InventoryService InventoryService;

	// Save operation
	@PostMapping("/Inventorys")
	public Inventory saveInventory(@Valid @RequestBody Inventory Inventory) {
		return InventoryService.saveInventory(Inventory);
	}

	// Read operation
	@GetMapping("/Inventorys")
	public List<Inventory> fetchInventoryList() {
		return InventoryService.fetchInventoryList();
	}

	// Update operation
	@PutMapping("/Inventorys/{id}")
	public Inventory updateInventory(@RequestBody Inventory Inventory, @PathVariable("id") Long inventoryId) {
		return InventoryService.updateInventory(Inventory, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/Inventorys/{id}")
	public String deleteInventoryById(@PathVariable("id") Long inventoryId) {
		InventoryService.deleteInventoryById(inventoryId);
		return "Deleted Successfully";
	}
}
