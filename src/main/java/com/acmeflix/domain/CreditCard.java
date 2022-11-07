package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "CREDIT_CARDS", indexes = {@Index(columnList = "card_number", unique = true)})
@SequenceGenerator(name = "idGenerator", sequenceName = "CREDIT_CARDS_SEQ", initialValue = 1, allocationSize = 1)
public class CreditCard extends BaseModel {
	@Column(name = "card_number", nullable = false, unique = true, length = 16)
	private String cardNumber;

	@Column(name = "card_holder", nullable = false, length = 30)
	private String cardHolder;

	@Column(name = "expiration_date", nullable = false, length = 5)
	private String expirationDate;

	@Column(name = "security_code", nullable = false, length = 3)
	private Integer securityCode;

	@ToString.Exclude
	@ManyToOne(optional = false)
	private Account account;

}
