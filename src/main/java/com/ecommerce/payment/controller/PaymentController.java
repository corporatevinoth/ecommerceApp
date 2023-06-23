package com.ecommerce.payment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.payment.client.OrderClient;
import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
public class PaymentController {

	private static Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;

	@Autowired
	OrderClient orderclient;

	// Save operation
	@PostMapping("/payment")
	public Payment savePayment(@Valid @RequestBody Payment payment) {
		LOGGER.info("savePayment of PaymentController");

		return paymentService.savePayment(payment);
	}

	// Read operation
	@GetMapping("/payment")
	public List<Payment> fetchPaymentList() {
		LOGGER.info("fetchPaymentList of PaymentController");

		return paymentService.fetchPaymentList();
	}
	

	@GetMapping("/payment/{id}")
	public Payment getPayment(@PathVariable("id") Long paymentId) {
		LOGGER.info("getPayment of PaymentController");

		return paymentService.findByInventoryId(paymentId);
	}

	// Update operation
	@PutMapping("/payment/{id}")
	public Payment updatePayment(@RequestBody Payment payment, @PathVariable("id") Long inventoryId) {
		LOGGER.info("updatePayment of PaymentController");

		return paymentService.updatePayment(payment, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/payment/{id}")
	public String deletePaymentById(@PathVariable("id") Long inventoryId) {
		LOGGER.info("deletePaymentById of PaymentController");

		paymentService.deletePaymentById(inventoryId);
		return "Deleted Successfully";
	}

	@GetMapping("/payment/with-order")
	public List<Payment> findAllWithOrders() {
		LOGGER.info("savePayment of PaymentController");

		List<Payment> payments = paymentService.findAll();
		payments.forEach(payment -> payment.setOrders(orderclient.getOrderByOrderId(payment.getOrderId())));
		return payments;
	}
}
