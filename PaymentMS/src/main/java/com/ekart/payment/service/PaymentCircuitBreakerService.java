package com.ekart.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class PaymentCircuitBreakerService {
		
	@Autowired
	private RestTemplate template;
	// Add necessary CircuitBreaker annotation
	@CircuitBreaker(name = "orderService")
	public void updateOrderAfterPayment(Integer orderId,String transactionStatus) {
		template.put("http://CustomerMS/Ekart/customerorder-api/order/"+orderId+"/update/order-status", transactionStatus);
	}
}
