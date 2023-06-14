package com.ecommerce.payment.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class PaymentEventConsumer {
	private static Logger LOGGER = LoggerFactory.getLogger(PaymentEventConsumer.class);

//	@KafkaListener(topics = "orderTopic", 
//			groupId = "group-id")
	public void consume(String product) 
	{
		LOGGER.info(String.format("Order created -> %s", product));
	}
}
