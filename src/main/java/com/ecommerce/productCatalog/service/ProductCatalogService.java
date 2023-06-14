package com.ecommerce.productCatalog.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.productCatalog.model.ProductCatalog;
import com.ecommerce.productCatalog.repository.ProductCatalogRepository;

@Service
public class ProductCatalogService {
	 @Autowired
	    private ProductCatalogRepository productCatalogRepository;
	 
	    // Save operation
	    
	    public ProductCatalog saveProductCatalog(ProductCatalog bill)
	    {
	        return productCatalogRepository.save(bill);
	    }
	 
	    // Read operation
	     public List<ProductCatalog> fetchProductCatalogList()
	    {
	        return (List<ProductCatalog>)
	            productCatalogRepository.findAll();
	    }
	 
	    // Update operation
	    public ProductCatalog
	    updateProductCatalog(ProductCatalog bill,
	                     Long billNo)
	    {
	 
	        ProductCatalog depDB
	            = productCatalogRepository.findById(billNo)
	                  .get();
	 
	        if (Objects.nonNull(bill.getProductName())
	            && !"".equalsIgnoreCase(
	                bill.getProductName())) {
	            depDB.setProductName(
	                bill.getProductName());
	        }
	 
	        return productCatalogRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deleteProductCatalogById(Long billNo)
	    {
	        productCatalogRepository.deleteById(billNo);
	    }
}
