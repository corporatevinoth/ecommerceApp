package com.ecommerce.payment.controller;

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
import org.springframework.web.client.HttpClientErrorException;

import com.ecommerce.payment.errorresponse.OrderNotFoundException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class PaymentExceptionController {
	private static Logger LOGGER = LoggerFactory.getLogger(PaymentExceptionController.class);


	@ExceptionHandler(value = NoSuchElementException.class)
	   public ResponseEntity<Object> exception(NoSuchElementException  exception) {
		LOGGER.error("NoSuchElementException handler from PaymentExceptionController");

	      return new ResponseEntity<>("Payment not found", HttpStatus.NOT_FOUND);
	   }
	

	@ExceptionHandler(value = OrderNotFoundException.class)
	   public ResponseEntity<Object> exception(OrderNotFoundException  e) {
		LOGGER.error("OrderNotFoundException handler from PaymentExceptionController");

	      return new ResponseEntity<>("Order not found, Please check orderId \n"+e.getMessage(), HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
		LOGGER.error("DataIntegrityViolationException handler from PaymentExceptionController");

	      return new ResponseEntity<>("Existing Payment with Same Payment code", HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	   public ResponseEntity<Object> exception(MethodArgumentNotValidException e) {
		LOGGER.error("MethodArgumentNotValidException handler from PaymentExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	   public ResponseEntity<Object> exception(HttpMessageNotReadableException e) {
		LOGGER.error("ConstraintViolationException handler from PaymentExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	   public ResponseEntity<Object> exception(ConstraintViolationException e) {
		LOGGER.error("ConstraintViolationException handler from PaymentExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = HttpClientErrorException.class)
	   public ResponseEntity<Object> exception(HttpClientErrorException e) {
		LOGGER.error("HttpClientErrorException handler from PaymentExceptionController");

	      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	   }
}