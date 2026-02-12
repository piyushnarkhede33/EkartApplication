package com.ekart.customer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
	@NotNull(message = "{cartproduct.productid.absent}")
	private Integer productId;
	private String name;
	private String description;
	private String category;
	private String brand;
	private Double price;
	private Integer availableQuantity;
}
