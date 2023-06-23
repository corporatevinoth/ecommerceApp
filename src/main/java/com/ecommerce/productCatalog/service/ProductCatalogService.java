package com.ecommerce.productCatalog.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.productCatalog.model.ProductCatalog;
import com.ecommerce.productCatalog.repository.ProductCatalogRepository;

@Service
public class ProductCatalogService {
	@Autowired
	private ProductCatalogRepository productCatalogRepository;

	private static Logger LOGGER = LoggerFactory.getLogger(ProductCatalogService.class);
	// Save operation
	public ProductCatalog saveProductCatalog(ProductCatalog productCatalog) {
		LOGGER.info("saveProductCatalog of ProductCatalogService" );

		return productCatalogRepository.save(productCatalog);
	}

	// Read operation
	public List<ProductCatalog> fetchProductCatalogList() {
		LOGGER.info("fetchProductCatalogList of ProductCatalogService" );
		return (List<ProductCatalog>) productCatalogRepository.findAll();
	}

	// Update operation
	public ProductCatalog updateProductCatalog(ProductCatalog productCatalog, Long productCatalogNo) {
		LOGGER.info("updateProductCatalog of ProductCatalogService" );

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
		LOGGER.info("deleteProductCatalogById of ProductCatalogService" );
		productCatalogRepository.deleteById(productCatalogNo);
	}

	public Optional<ProductCatalog> findByproductCatalogId(Long productCatalogId) {
		LOGGER.info("findByproductCatalogId of ProductCatalogService" );

		return productCatalogRepository.findById(productCatalogId);
	}
}
