package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Person;
import com.acmeflix.transfer.resource.PersonResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CastMemberMapper.class})
public interface PersonMapper extends BaseMapper<Person, PersonResource> {
}
