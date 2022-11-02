package com.acmeflix.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class SubscriptionPlan extends BaseModel {
	private String title;
	private String description;
	private BigDecimal costPerMonth;
}
