package com.acmeflix.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class CreditCard extends BaseModel {
	private String cardNumber;
	private String cardHolder;
	private String expirationDate;
	private Integer securityCode;
}
