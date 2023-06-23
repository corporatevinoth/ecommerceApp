package com.ecommerce.inventory.controller;

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

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.service.InventoryService;

import jakarta.validation.Valid;

@RestController
public class InventoryController {
	private static Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	@Autowired
	private InventoryService inventoryService;

	// Save operation
	@PostMapping("/inventory")
	public Inventory saveInventory(@Valid @RequestBody Inventory Inventory) {
		LOGGER.info("saveInventory reached in InventoryController");

		return inventoryService.saveInventory(Inventory);
	}

	// Read operation
	@GetMapping("/inventory")
	public List<Inventory> fetchInventoryList() {
		LOGGER.info("fetchInventoryList reached in InventoryController");

		return inventoryService.fetchInventoryList();
	}
	
	@GetMapping("/inventory/{id}")
	public Inventory getInventory(@PathVariable("id") Long inventoryId) {
		LOGGER.info("getInventory reached in InventoryController");

		return inventoryService.findByInventoryId(inventoryId).get();
	}

	// Update operation
	@PutMapping("/inventory/{id}")
	public Inventory updateInventory(@RequestBody Inventory Inventory, @PathVariable("id") Long inventoryId) {
		LOGGER.info("updateInventory reached in InventoryController");

		return inventoryService.updateInventory(Inventory, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/inventory/{id}")
	public String deleteInventoryById(@PathVariable("id") Long inventoryId) {
		LOGGER.info("deleteInventoryById reached in InventoryController");

		inventoryService.deleteInventoryById(inventoryId);
		return "Deleted Successfully";
	}
}
