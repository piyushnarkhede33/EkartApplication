package com.ekart.product.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ProductDTO {
	
	private Integer productId;
	@Pattern(regexp = "(a-zA-Z- .)", message = "{product.invalid.name}")
	private String name;
	private String description;
	private String category;
	private String brand;
	private Double price;
	private Integer availableQuantity;

}
