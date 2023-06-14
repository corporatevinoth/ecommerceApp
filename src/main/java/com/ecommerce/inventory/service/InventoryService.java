package com.ecommerce.inventory.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	 @Autowired
	    private InventoryRepository inventoryRepository;
	 
	    // Save operation
	    
	    public Inventory saveInventory(Inventory inventory)
	    {
	        return inventoryRepository.save(inventory);
	    }
	 
	    // Read operation
	     public List<Inventory> fetchInventoryList()
	    {
	        return (List<Inventory>)
	            inventoryRepository.findAll();
	    }
	 
	    // Update operation
	    public Inventory
	    updateInventory(Inventory inventory,
	                     Long inventoryID)
	    {
	 
	        Inventory depDB
	            = inventoryRepository.findById(inventoryID)
	                  .get();
	 
	        if (Objects.nonNull(inventory.getInventoryname())
	            && !"".equalsIgnoreCase(
	                inventory.getInventoryname())) {
	            depDB.setInventoryname(
	                inventory.getInventoryname());
	        }
	 
	        if (Objects.nonNull(
	                inventory.getInventoryDescription())
	            && !"".equalsIgnoreCase(
	                inventory.getInventoryDescription())) {
	            depDB.setInventoryDescription(
	                inventory.getInventoryDescription());
	        }
	 
	        if (Objects.nonNull(inventory.getTotalCapacity())
	            && 
	                inventory.getTotalCapacity()>10) {
	            depDB.setTotalCapacity(
	                inventory.getTotalCapacity());
	        }
	        if (Objects.nonNull(inventory.getAvailableCapacity())
		            && 
		                inventory.getAvailableCapacity()>10) {
		            depDB.setAvailableCapacity(
		                inventory.getAvailableCapacity());
		    }
	        if (Objects.nonNull(inventory.getStatus())
		            ) {
		            depDB.setStatus(
		            		inventory.getStatus());
		    }
	 
	        return inventoryRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deleteInventoryById(Long inventoryID)
	    {
	        inventoryRepository.deleteById(inventoryID);
	    }
}
