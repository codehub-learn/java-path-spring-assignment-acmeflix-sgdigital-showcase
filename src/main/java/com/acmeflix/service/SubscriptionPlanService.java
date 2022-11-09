package com.acmeflix.service;

import com.acmeflix.domain.SubscriptionPlan;

public interface SubscriptionPlanService extends BaseService<SubscriptionPlan, Long> {
	SubscriptionPlan getByTitle(String title);
}
