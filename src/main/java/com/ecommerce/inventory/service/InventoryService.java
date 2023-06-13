package com.ecommerce.inventory.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.inventory.model.Product;
import com.ecommerce.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	 @Autowired
	    private InventoryRepository inventoryRepository;
	 
	    // Save operation
	    
	    public Product saveProduct(Product product)
	    {
	        return inventoryRepository.save(product);
	    }
	 
	    // Read operation
	     public List<Product> fetchProductList()
	    {
	        return (List<Product>)
	            inventoryRepository.findAll();
	    }
	 
	    // Update operation
	    public Product
	    updateProduct(Product product,
	                     Long inventoryID)
	    {
	 
	        Product depDB
	            = inventoryRepository.findById(inventoryID)
	                  .get();
	 
	        if (Objects.nonNull(product.getName())
	            && !"".equalsIgnoreCase(
	                product.getName())) {
	            depDB.setName(
	                product.getName());
	        }
	 
	        if (Objects.nonNull(
	                product.getDescription())
	            && !"".equalsIgnoreCase(
	                product.getDescription())) {
	            depDB.setDescription(
	                product.getDescription());
	        }
	 
	        if (Objects.nonNull(product.getBatchNo())
	            && !"".equalsIgnoreCase(
	                product.getBatchNo())) {
	            depDB.setBatchNo(
	                product.getBatchNo());
	        }
	 
	        return inventoryRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deleteProductById(Long inventoryID)
	    {
	        inventoryRepository.deleteById(inventoryID);
	    }
}
