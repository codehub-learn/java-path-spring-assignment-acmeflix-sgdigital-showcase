package com.acmeflix.service;

import com.acmeflix.domain.SubscriptionPlan;
import com.acmeflix.repository.SubscriptionPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionPlanServiceImpl extends BaseServiceImpl<SubscriptionPlan> implements SubscriptionPlanService {
	private final SubscriptionPlanRepository subscriptionPlanRepository;

	@Override
	public JpaRepository<SubscriptionPlan, Long> getRepository() {
		return subscriptionPlanRepository;
	}

	@Override
	public SubscriptionPlan getByTitle(final String title) {
		return subscriptionPlanRepository.getByTitleIgnoreCase(title);
	}
}
