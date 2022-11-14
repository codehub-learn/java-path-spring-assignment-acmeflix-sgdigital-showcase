package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CreditCardResource extends BaseModelResource {
	private String cardNumber;
	private String cardHolder;
	private String expirationDate;
	private Integer securityCode;
}
