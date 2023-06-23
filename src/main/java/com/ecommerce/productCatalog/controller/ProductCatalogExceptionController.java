package com.ecommerce.productCatalog.controller;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ProductCatalogExceptionController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProductCatalogExceptionController.class);


	@ExceptionHandler(value = NoSuchElementException.class)
	   public ResponseEntity<Object> exception(NoSuchElementException  exception) {
		LOGGER.error("NoSuchElementException handler from ProductCatalogExceptionController");

	      return new ResponseEntity<>("Product Catalog not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
		LOGGER.error("DataIntegrityViolationException handler from ProductCatalogExceptionController");

	      return new ResponseEntity<>("Existing Product Catalog with Same Product Catalog code", HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	   public ResponseEntity<Object> exception(MethodArgumentNotValidException e) {
		LOGGER.error("MethodArgumentNotValidException handler from ProductCatalogExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	   public ResponseEntity<Object> exception(HttpMessageNotReadableException e) {
		LOGGER.error("HttpMessageNotReadableException handler from ProductCatalogExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	   public ResponseEntity<Object> exception(ConstraintViolationException e) {
		LOGGER.error("ConstraintViolationException handler from ProductCatalogExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
}