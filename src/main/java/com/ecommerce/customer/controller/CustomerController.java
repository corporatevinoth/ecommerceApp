package com.ecommerce.customer.controller;

import java.util.List;
import java.util.Optional;

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

import com.ecommerce.customer.errorResponse.CustomerNotFoundException;
import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	// Save operation
	@PostMapping("/customer")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		LOGGER.info("saving the customer info reached CustomerController");

		return customerService.saveCustomer(customer);
	}

	// Read operation
	@GetMapping("/customer")
	public List<Customer> fetchCustomerList() {
		LOGGER.info("fetch the customer info reached CustomerController");

		return customerService.fetchCustomerList();
	}

	// Read operation
	@GetMapping("/customer/{id}")
	public Optional<Customer> fetchCustomer(@PathVariable("id") Long customerId) {
		LOGGER.info("fetch the customer info reached CustomerController");

		return customerService.fetchCustomer(customerId);
	}

	// Update operation
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@Valid @RequestBody Customer customer, @PathVariable("id") Long customerId) {
		LOGGER.info("update the customer info reached CustomerController");

		if (!customerService.fetchCustomer(customerId).isPresent())
			throw new CustomerNotFoundException();

		return customerService.updateCustomer(customer, customerId);
	}

	// Delete operation
	@DeleteMapping("/customer/{id}")
	public String deleteCustomerById(@PathVariable("id") Long customerId) {
		LOGGER.info("delete the customer info reached CustomerController");

		customerService.deleteCustomerById(customerId);
		return "Deleted Successfully";
	}
}
