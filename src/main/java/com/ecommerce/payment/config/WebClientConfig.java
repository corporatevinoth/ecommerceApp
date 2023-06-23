package com.ecommerce.payment.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.ecommerce.payment.client.OrderClient;

@Configuration
public class WebClientConfig {
	private static Logger LOGGER = LoggerFactory.getLogger(WebClientConfig.class);
	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;
	
	@Bean
	public WebClient orderWebClient() {
		LOGGER.info("WebClient initialized");

		return WebClient.builder()
				.baseUrl("http://localhost:8091")
				.build();
	}
	
	@Bean
    public OrderClient orderClient() {
		LOGGER.info("orderClient of WebClientConfig called");

        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(orderWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(OrderClient.class);
    }
}
