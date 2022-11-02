package com.acmeflix.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Account extends BaseModel {
	private String email;
	private String password;
	private String phoneNumber;
	private SubscriptionPlan subscriptionPlan;
	private Set<CreditCard> creditCards = new HashSet<>();
	private Set<Profile> profiles = new HashSet<>();
}
