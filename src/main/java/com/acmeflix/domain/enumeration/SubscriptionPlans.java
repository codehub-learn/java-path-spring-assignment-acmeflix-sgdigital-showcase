package com.acmeflix.domain.enumeration;

import com.acmeflix.domain.SubscriptionPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum SubscriptionPlans {
	//@formatter:off
	BASIC(SubscriptionPlan.builder()
						  .title("Basic")
						  .description("Good video quality in SD (480p).")
						  .costPerMonth(BigDecimal.valueOf(7.99)).build()),
	STANDARD(SubscriptionPlan.builder()
							 .title("Standard")
							 .description("Great video quality in Full HD (1080p).")
							 .costPerMonth(BigDecimal.valueOf(10.99)).build()),
	PREMIUM(SubscriptionPlan.builder()
							.title("Premium")
							.description("Best video quality in Ultra HD (4K) and HDR.")
							.costPerMonth(BigDecimal.valueOf(13.99)).build());

	//@formatter:on
	private final SubscriptionPlan subscriptionPlan;
}
