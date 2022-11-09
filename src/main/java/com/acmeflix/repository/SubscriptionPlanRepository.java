package com.acmeflix.repository;

import com.acmeflix.domain.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
	SubscriptionPlan getByTitleIgnoreCase(String title);
}
