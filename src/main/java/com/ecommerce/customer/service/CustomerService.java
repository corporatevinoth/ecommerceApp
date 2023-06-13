package com.ecommerce.customer.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	 @Autowired
	    private CustomerRepository customeringRepository;
	 
	    // Save operation
	    
	    public Customer saveCustomer(Customer customer)
	    {
	        return customeringRepository.save(customer);
	    }
	 
	    // Read operation
	     public List<Customer> fetchCustomerList()
	    {
	        return (List<Customer>)
	            customeringRepository.findAll();
	    }
	 
	    // Update operation
	    public Customer
	    updateCustomer(Customer customer,
	                     Long customerId)
	    {
	 
	        Customer depDB
	            = customeringRepository.findById(customerId)
	                  .get();
	 
	        if (Objects.nonNull(customer.getReceiverName())
	            && !"".equalsIgnoreCase(
	                customer.getReceiverName())) {
	            depDB.setReceiverName(
	                customer.getReceiverName());
	        }
	 
	        if (Objects.nonNull(
	                customer.getCustomerAddress())
	            && !"".equalsIgnoreCase(
	                customer.getCustomerAddress())) {
	            depDB.setCustomerAddress(
	                customer.getCustomerAddress());
	        }
	 
	        if (Objects.nonNull(customer.getDeliveryDate())) {
	            depDB.setDeliveryDate(
	                customer.getDeliveryDate());
	        }
	 
	        return customeringRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deleteCustomerById(Long customerId)
	    {
	        customeringRepository.deleteById(customerId);
	    }
}
