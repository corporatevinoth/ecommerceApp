package com.ecommerce.customer.controller;

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

	@ExceptionHandler(value = CustomerNotFoundException.class)
	   public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
	      return new ResponseEntity<>("Inventory not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
	      return new ResponseEntity<>("Existing Inventory with Phone Number", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	   public ResponseEntity<Object> exception(MethodArgumentNotValidException e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	   }
	

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	   public ResponseEntity<Object> exception(HttpMessageNotReadableException e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	   public ResponseEntity<Object> exception(ConstraintViolationException e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	
	
}