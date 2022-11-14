package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
public class SubscriptionPlanResource extends BaseModelResource {
	private String title;
	private String description;
	private BigDecimal costPerMonth;
}
