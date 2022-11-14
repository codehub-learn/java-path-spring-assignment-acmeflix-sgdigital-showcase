package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.CreditCard;
import com.acmeflix.transfer.resource.CreditCardResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditCardMapper extends BaseMapper<CreditCard, CreditCardResource> {
}
