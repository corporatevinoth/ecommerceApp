package com.ecommerce.payment.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.repository.PaymentRepository;

@Service
public class PaymentService {
	 @Autowired
	    private PaymentRepository paymentRepository;
	 
	    // Save operation
	    
	    public Payment savePayment(Payment bill)
	    {
	        return paymentRepository.save(bill);
	    }
	 
	    // Read operation
	     public List<Payment> fetchPaymentList()
	    {
	        return (List<Payment>)
	            paymentRepository.findAll();
	    }
	 
	    // Update operation
	    public Payment
	    updatePayment(Payment bill,
	                     Long billNo)
	    {
	 
	        Payment depDB
	            = paymentRepository.findById(billNo)
	                  .get();
	 
	        if (Objects.nonNull(bill.getProductName())
	            && !"".equalsIgnoreCase(
	                bill.getProductName())) {
	            depDB.setProductName(
	                bill.getProductName());
	        }
	 
	        if (Objects.nonNull(
	                bill.getDescription())
	            && !"".equalsIgnoreCase(
	                bill.getDescription())) {
	            depDB.setDescription(
	                bill.getDescription());
	        }
	 
	        if (Objects.nonNull(bill.getBatchNo())
	            && !"".equalsIgnoreCase(
	                bill.getBatchNo())) {
	            depDB.setBatchNo(
	                bill.getBatchNo());
	        }
	 
	        return paymentRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deletePaymentById(Long billNo)
	    {
	        paymentRepository.deleteById(billNo);
	    }
}
