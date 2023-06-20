package com.ecommerce.inventory.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;

	// Save operation

	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	// Read operation
	public List<Inventory> fetchInventoryList() {
		return (List<Inventory>) inventoryRepository.findAll();
	}

	// Update operation
	public Inventory updateInventory(Inventory inventory, Long inventoryID) {

		Inventory dbDataObj = inventoryRepository.findById(inventoryID).get();

		if (Objects.nonNull(inventory.getInventoryname()) && !"".equalsIgnoreCase(inventory.getInventoryname())) {
			dbDataObj.setInventoryname(inventory.getInventoryname());
		}

		if (Objects.nonNull(inventory.getInventoryAddress()) && !"".equalsIgnoreCase(inventory.getInventoryAddress())) {
			dbDataObj.setInventoryAddress(inventory.getInventoryAddress());
		}

		if (Objects.nonNull(inventory.getTotalCapacity()) && inventory.getTotalCapacity() > 10) {
			dbDataObj.setTotalCapacity(inventory.getTotalCapacity());
		}
		if (Objects.nonNull(inventory.getAvailableCapacity()) && inventory.getAvailableCapacity() > 10) {
			dbDataObj.setAvailableCapacity(inventory.getAvailableCapacity());
		}
		if (Objects.nonNull(inventory.getStatus())) {
			dbDataObj.setStatus(inventory.getStatus());
		}

		return inventoryRepository.save(dbDataObj);
	}

	// Delete operation
	public void deleteInventoryById(Long inventoryID) {
		inventoryRepository.deleteById(inventoryID);
	}

	public Optional<Inventory> findByInventoryId(Long inventoryId) {
		return inventoryRepository.findById(inventoryId);
	}
}
