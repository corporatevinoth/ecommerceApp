package com.ecommerce.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Save operation
	@PostMapping("/customer")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	// Read operation
	@GetMapping("/customer")
	public List<Customer> fetchCustomerList() {
		return customerService.fetchCustomerList();
	}

	// Update operation
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long customerId) {
		return customerService.updateCustomer(customer, customerId);
	}

	// Delete operation
	@DeleteMapping("/customer/{id}")
	public String deleteCustomerById(@PathVariable("id") Long customerId) {
		customerService.deleteCustomerById(customerId);
		return "Deleted Successfully";
	}
}
