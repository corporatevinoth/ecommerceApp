package com.ecommerce.payment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.payment.errorresponse.OrderNotFoundException;
import com.ecommerce.payment.model.Order;
import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {

	private static Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentRepository paymentRepository;

	private RestTemplate restTemplate;

	// Save operation

	public Payment savePayment(Payment payment) {
		try {

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("fromPayment", "true");

			String url = "http://localhost:8091/payment/order/{orderId}/{frompayment}";
			Map<String, String> map = new HashMap<>();
			map.put("orderId", payment.getOrderId());
			map.put("frompayment", "true");

			List<Order> orderList = restTemplate.getForObject(url, List.class, map);
			LOGGER.info("order details collected" + orderList);
			payment.setOrders(orderList);
			if (orderList != null && (orderList).size() > 0) {
				return paymentRepository.save(payment);
			} else {
				LOGGER.error("error while fetching order details collected for orderId" + payment.getOrderId());
				throw new OrderNotFoundException("Order Not Found for " + payment.getOrderId());

			}
		} catch (Exception e) {
			throw new OrderNotFoundException("Order Not Found for " + payment.getOrderId());
		}

	}

	// Read operation
	public List<Payment> fetchPaymentList() {
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8091/payment/order/{orderId}/{frompayment}";
		Map<String, String> map = new HashMap<>();
		map.put("frompayment", "true");

		List<Payment> paymentDtlsList = (List<Payment>) paymentRepository.findAll();
		for (Payment payment : paymentDtlsList) {
			map.put("orderId", payment.getOrderId());
			List<Order> orderList = new ArrayList<Order>();
			try {
				orderList = restTemplate.getForObject(url, List.class, map);
				LOGGER.info("order details collected for orderId" + payment.getOrderId());

			} catch (Exception e) {
				LOGGER.error("error while fetching order details collected for orderId" + payment.getOrderId());
			}
			payment.setOrders(orderList);
		}
		return paymentDtlsList;
	}

	// Update operation
	public Payment updatePayment(Payment payment, Long paymentNo) {

		Payment dbDataObj = paymentRepository.findById(paymentNo).get();

		if (Objects.nonNull(payment.getPaymentDate())) {
			dbDataObj.setPaymentDate(payment.getPaymentDate());
		}

		if (Objects.nonNull(payment.getDiscount())) {
			dbDataObj.setDiscount(payment.getDiscount());
		}
		if (Objects.nonNull(payment.getGst())) {
			dbDataObj.setGst(payment.getGst());
		}
		if (Objects.nonNull(payment.getMrp())) {
			dbDataObj.setMrp(payment.getMrp());
		}
		if (Objects.nonNull(payment.getPaymentType())) {
			dbDataObj.setPaymentType(payment.getPaymentType());
		}
		if (Objects.nonNull(payment.getStatus())) {
			dbDataObj.setStatus(payment.getStatus());
		}
		return paymentRepository.save(dbDataObj);
	}

	// Delete operation
	public void deletePaymentById(Long paymentNo) {
		paymentRepository.deleteById(paymentNo);
	}

	public Payment findByInventoryId(Long paymentId) {
		Payment resultPayment =  paymentRepository.findById(paymentId).get();
		
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8091/payment/order/{orderId}/{frompayment}";
		Map<String, String> map = new HashMap<>();
		map.put("frompayment", "true");

		
		map.put("orderId", resultPayment.getOrderId());
		List<Order> orderList = new ArrayList<Order>();
		try {
			orderList = restTemplate.getForObject(url, List.class, map);
			LOGGER.info("order details collected for orderId" + resultPayment.getOrderId());

		} catch (Exception e) {
			LOGGER.error("error while fetching order details collected for orderId" + resultPayment.getOrderId());
		}
		resultPayment.setOrders(orderList);
		
		return resultPayment;

	}
}
