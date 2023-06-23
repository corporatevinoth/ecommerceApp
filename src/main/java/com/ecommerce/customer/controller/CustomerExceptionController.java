package com.ecommerce.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.customer.errorResponse.CustomerNotFoundException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomerExceptionController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerExceptionController.class);


	@ExceptionHandler(value = CustomerNotFoundException.class)
	   public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
		LOGGER.error("CustomerNotFoundException handler from CustomerExceptionController");

	      return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
		LOGGER.error("DataIntegrityViolationException handler from CustomerExceptionController");

	      return new ResponseEntity<>("Existing Customer with Phone Number", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	   public ResponseEntity<Object> exception(MethodArgumentNotValidException e) {
		LOGGER.error("MethodArgumentNotValidException handler from CustomerExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	   }
	

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	   public ResponseEntity<Object> exception(HttpMessageNotReadableException e) {
		LOGGER.error("HttpMessageNotReadableException handler from CustomerExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	   public ResponseEntity<Object> exception(ConstraintViolationException e) {
		LOGGER.error("ConstraintViolationException handler from CustomerExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	
	
}