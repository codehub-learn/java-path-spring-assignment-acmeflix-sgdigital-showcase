package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "SUBSCRIPTION_PLANS")
@SequenceGenerator(name = "idGenerator", sequenceName = "SUBSCRIPTION_PLANS_SEQ", initialValue = 1, allocationSize = 1)
public class SubscriptionPlan extends BaseModel {
	@Column(nullable = false, length = 30)
	private String title;

	@Column(length = 100)
	private String description;

	@Column(name = "cost_per_month", nullable = false, precision = 5, scale = 2)
	private BigDecimal costPerMonth;
}
