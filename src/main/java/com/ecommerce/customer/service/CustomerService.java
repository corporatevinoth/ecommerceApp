package com.ecommerce.customer.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	 @Autowired
	    private CustomerRepository customerRepository;
	 
	    // Save operation
	    
	    public Customer saveCustomer(Customer customer)
	    {
	        return customerRepository.save(customer);
	    }
	 
	    // Read operation
	     public List<Customer> fetchCustomerList()
	    {
	        return (List<Customer>)
	            customerRepository.findAll();
	    }
	 
	    // Update operation
	    public Customer
	    updateCustomer(Customer customer,
	                     Long customerId)
	    {
	 
	        Customer depDB
	            = customerRepository.findById(customerId)
	                  .get();
	 
	        if (Objects.nonNull(customer.getCustomerName())
	            && !"".equalsIgnoreCase(
	                customer.getCustomerName())) {
	            depDB.setCustomerName(
	                customer.getCustomerName());
	        }
	 
	        if (Objects.nonNull(
	                customer.getCusotmerShippingAddress())
	            && !"".equalsIgnoreCase(
	                customer.getCusotmerShippingAddress())) {
	            depDB.setCusotmerShippingAddress(
	                customer.getCusotmerShippingAddress());
	        }
	 
	        
	 
	        return customerRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deleteCustomerById(Long customerId)
	    {
	        customerRepository.deleteById(customerId);
	    }

		public Optional<Customer> fetchCustomer(Long id) {
			
		        return customerRepository.findById(id);
		    
		}
}
