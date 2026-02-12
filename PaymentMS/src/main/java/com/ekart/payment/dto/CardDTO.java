package com.ekart.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDTO {
	
	private String cardType;
	private String cardNumber;
	private String nameOnCard;
	private String hashCvv;
	@NotNull(message = "{transaction.cvv.notpresent}")
	private Integer cvv;
	private String expiryYear;
	private String expiryMonth;
	@NotNull(message = "{transaction.cardId.notpresent}")
	private Integer cardId;
	private String customerEmailId;

}
