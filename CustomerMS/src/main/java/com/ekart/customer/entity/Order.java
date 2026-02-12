package com.ekart.customer.entity;

import com.ekart.customer.dto.OrderStatus;
import com.ekart.customer.dto.PaymentThrough;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "EK_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	private String customerEmailId;

	private LocalDateTime dateOfOrder;

	private Double discount;

	private Double totalPrice;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@Enumerated(EnumType.STRING)
	private PaymentThrough paymentThrough;

	private LocalDateTime dateOfDelivery;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private List<OrderedProduct> orderedProducts;
    
	private String deliveryAddress;

}
