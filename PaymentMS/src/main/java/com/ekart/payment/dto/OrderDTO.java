package com.ekart.payment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
	@NotNull(message = "{transaction.orderid.notpresent}")
	private Integer orderId;
	private String customerEmailId;
	private LocalDateTime dateOfOrder;
	private Double totalPrice;
	private Double discount;
	private String orderStatus;
	private String paymentThrough;
}
