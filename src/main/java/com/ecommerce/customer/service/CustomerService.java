package com.ecommerce.customer.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private CustomerRepository customerRepository;

	// Save operation

	public Customer saveCustomer(Customer customer) {
		LOGGER.info("saveCustomer from CustomerService" + customer);

		return customerRepository.save(customer);
	}

	// Read operation
	public List<Customer> fetchCustomerList() {
		LOGGER.info("fetchCustomerList from CustomerService" );

		return (List<Customer>) customerRepository.findAll();
	}

	// Update operation
	public Customer updateCustomer(Customer customer, Long customerId) {
		LOGGER.info("updateCustomer from CustomerService" + customer);

		Customer dbDataObj = customerRepository.findById(customerId).get();

		if (Objects.nonNull(customer.getCustomerName()) && !"".equalsIgnoreCase(customer.getCustomerName())) {
			dbDataObj.setCustomerName(customer.getCustomerName());
		}

		if (Objects.nonNull(customer.getCusotmerShippingAddress())
				&& !"".equalsIgnoreCase(customer.getCusotmerShippingAddress())) {
			dbDataObj.setCusotmerShippingAddress(customer.getCusotmerShippingAddress());
		}

		return customerRepository.save(dbDataObj);
	}

	public void deleteCustomerById(Long customerId) {
		LOGGER.info("deleteCustomerById from CustomerService" );

		customerRepository.deleteById(customerId);
	}

	public Optional<Customer> fetchCustomer(Long id) {
		LOGGER.info("fetchCustomer from CustomerService" );

		return customerRepository.findById(id);

	}
}
