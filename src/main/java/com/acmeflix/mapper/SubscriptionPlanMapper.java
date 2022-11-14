package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.SubscriptionPlan;
import com.acmeflix.transfer.resource.SubscriptionPlanResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionPlanMapper extends BaseMapper<SubscriptionPlan, SubscriptionPlanResource> {
}
