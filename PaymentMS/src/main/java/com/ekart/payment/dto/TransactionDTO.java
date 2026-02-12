package com.ekart.payment.dto;

import jakarta.validation.Valid;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class TransactionDTO {
	
	private Integer transactionId;
	@Valid
	private OrderDTO order;
	@Valid
	private CardDTO card;
	private Double totalPrice;
	private LocalDateTime transactionDate;
	private TransactionStatus transactionStatus;
}
