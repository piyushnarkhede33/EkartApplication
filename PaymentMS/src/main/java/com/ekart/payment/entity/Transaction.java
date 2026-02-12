package com.ekart.payment.entity;

import com.ekart.payment.dto.TransactionStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="EK_TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer transactionId;
	private Integer orderId;
	private Integer cardId;
	private Double totalPrice;
	private LocalDateTime transactionDate;
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;

}
