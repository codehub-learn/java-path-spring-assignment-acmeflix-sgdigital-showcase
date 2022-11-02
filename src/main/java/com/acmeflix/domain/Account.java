package com.acmeflix.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "ACCOUNTS", indexes = {@Index(columnList = "email", unique = true)})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel {
	private String email;
	private String password;
	private String phoneNumber;
	private SubscriptionPlan subscriptionPlan;
	private Set<CreditCard> creditCards = new HashSet<>();
	private Set<Profile> profiles = new HashSet<>();
}
