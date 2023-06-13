package com.ecommerce.order.messaging;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.order.model.Order;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderEventProducer {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	private static Logger LOGGER = LoggerFactory.getLogger(OrderEventProducer.class);

	private static final String TOPIC = "orderTopic";

	// Publish messages using the GetMapping
	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable("message") final String message) {

		// Sending the message
		kafkaTemplate.send(TOPIC, message);

		return "Published Successfully";
	}
	
	public String publishMessage(Order order) {

		// Sending the message
		order.getProducts().forEach(product->kafkaTemplate.send(TOPIC, product.toString()));
		LOGGER.info("order id : {} published successfully",order.getOrderId());
		return "Published Successfully";
	}
}
