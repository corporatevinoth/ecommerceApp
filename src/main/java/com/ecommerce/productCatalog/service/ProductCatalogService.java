package com.ecommerce.productCatalog.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.productCatalog.model.ProductCatalog;
import com.ecommerce.productCatalog.repository.ProductCatalogRepository;

@Service
public class ProductCatalogService {
	@Autowired
	private ProductCatalogRepository productCatalogRepository;

	// Save operation
	public ProductCatalog saveProductCatalog(ProductCatalog productCatalog) {
		return productCatalogRepository.save(productCatalog);
	}

	// Read operation
	public List<ProductCatalog> fetchProductCatalogList() {
		return (List<ProductCatalog>) productCatalogRepository.findAll();
	}

	// Update operation
	public ProductCatalog updateProductCatalog(ProductCatalog productCatalog, Long productCatalogNo) {

		ProductCatalog dbDataObj = productCatalogRepository.findById(productCatalogNo).get();

		if (Objects.nonNull(productCatalog.getProductName()) && !"".equalsIgnoreCase(productCatalog.getProductName())) {
			dbDataObj.setProductName(productCatalog.getProductName());
		}

		if (Objects.nonNull(productCatalog.getProductCategory()) && !"".equalsIgnoreCase(productCatalog.getProductCategory())) {
			dbDataObj.setProductCategory(productCatalog.getProductCategory());
		}

		if (Objects.nonNull(productCatalog.getUnitPrice())) {
			dbDataObj.setUnitPrice(productCatalog.getUnitPrice());
		}
		if (Objects.nonNull(productCatalog.getQuantity())) {
			dbDataObj.setQuantity(productCatalog.getQuantity());
		}
		if (Objects.nonNull(productCatalog.getBatchNo())) {
			dbDataObj.setBatchNo(productCatalog.getBatchNo());
		}
		if (Objects.nonNull(productCatalog.getExpDate())) {
			dbDataObj.setExpDate(productCatalog.getExpDate());
		}
		if (Objects.nonNull(productCatalog.getMfgDate())) {
			dbDataObj.setMfgDate(productCatalog.getMfgDate());
		}

		return productCatalogRepository.save(dbDataObj);
	}

	// Delete operation
	public void deleteProductCatalogById(Long productCatalogNo) {
		productCatalogRepository.deleteById(productCatalogNo);
	}

	public Optional<ProductCatalog> findByproductCatalogId(Long productCatalogId) {

		return productCatalogRepository.findById(productCatalogId);
	}
}
