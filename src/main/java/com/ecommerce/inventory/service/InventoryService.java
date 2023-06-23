package com.ecommerce.inventory.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	private static Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);
	@Autowired
	private InventoryRepository inventoryRepository;

	// Save operation

	public Inventory saveInventory(Inventory inventory) {
		LOGGER.info("saveInventory from  InventoryService" );

		return inventoryRepository.save(inventory);
	}

	// Read operation
	public List<Inventory> fetchInventoryList() {
		LOGGER.info("saveInventory from  InventoryService" );

		return (List<Inventory>) inventoryRepository.findAll();
	}

	// Update operation
	public Inventory updateInventory(Inventory inventory, Long inventoryID) {
		LOGGER.info("saveInventory from  InventoryService" );


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
		LOGGER.info("deleteInventoryById from  InventoryService" );

		inventoryRepository.deleteById(inventoryID);
	}

	public Optional<Inventory> findByInventoryId(Long inventoryId) {
		LOGGER.info("findByInventoryId from  InventoryService" );

		return inventoryRepository.findById(inventoryId);
	}
}
