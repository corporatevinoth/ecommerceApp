package com.ecommerce.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	// Save operation
	@PostMapping("/payment")
	public Payment savePayment(@Valid @RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}

	// Read operation
	@GetMapping("/payment")
	public List<Payment> fetchPaymentList() {
		return paymentService.fetchPaymentList();
	}
	

	@GetMapping("/payment/{id}")
	public Payment getPayment(@PathVariable("id") Long paymentId) {
		return paymentService.findByInventoryId(paymentId).get();
	}

	// Update operation
	@PutMapping("/payment/{id}")
	public Payment updatePayment(@RequestBody Payment payment, @PathVariable("id") Long inventoryId) {
		return paymentService.updatePayment(payment, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/payment/{id}")
	public String deletePaymentById(@PathVariable("id") Long inventoryId) {
		paymentService.deletePaymentById(inventoryId);
		return "Deleted Successfully";
	}
}
