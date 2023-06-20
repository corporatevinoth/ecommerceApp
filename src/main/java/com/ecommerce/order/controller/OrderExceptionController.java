package com.ecommerce.order.controller;

import java.util.NoSuchElementException;

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

	@ExceptionHandler(value = NoSuchElementException.class)
	   public ResponseEntity<Object> exception(NoSuchElementException  exception) {
	      return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
	      return new ResponseEntity<>("Existing Order with Same Order Id", HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	   public ResponseEntity<Object> exception(MethodArgumentNotValidException e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	   public ResponseEntity<Object> exception(HttpMessageNotReadableException e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	   public ResponseEntity<Object> exception(ConstraintViolationException e) {
	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
}