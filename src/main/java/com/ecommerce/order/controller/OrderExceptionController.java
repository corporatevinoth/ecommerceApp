package com.ecommerce.order.controller;

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
public class OrderExceptionController {
	private static Logger LOGGER = LoggerFactory.getLogger(OrderExceptionController.class);

	
	@ExceptionHandler(value = NoSuchElementException.class)
	   public ResponseEntity<Object> exception(NoSuchElementException  exception) {
		LOGGER.error("NoSuchElementException handler from OrderExceptionController");

	      return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
		LOGGER.error("DataIntegrityViolationException handler from OrderExceptionController");

	      return new ResponseEntity<>("Existing Order with Same Order Id", HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	   public ResponseEntity<Object> exception(MethodArgumentNotValidException e) {
		LOGGER.error("HttpMessageNotReadableException handler from OrderExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	   public ResponseEntity<Object> exception(HttpMessageNotReadableException e) {
		LOGGER.error("HttpMessageNotReadableException handler from OrderExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	   public ResponseEntity<Object> exception(ConstraintViolationException e) {
		LOGGER.error("ConstraintViolationException handler from OrderExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
}