package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class AccountResource extends BaseModelResource {
	private String email;
	private String password;
	private String phoneNumber;
	private SubscriptionPlanResource subscriptionPlan;
	private Set<CreditCardResource> creditCards = new HashSet<>();
	private Set<ProfileResource> profiles = new HashSet<>();
}
