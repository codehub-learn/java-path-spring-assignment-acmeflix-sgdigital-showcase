package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.CastMember;
import com.acmeflix.transfer.resource.CastMemberResource;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CastMemberMapper extends BaseMapper<CastMember, CastMemberResource> {
	@Mapping(target = "contentTitle", source = "content.title")
	@Mapping(target = "personName", expression = "java(castMember.getPerson().getFirstName() + ' ' + castMember" +
			".getPerson().getLastName())")
	CastMemberResource toResource(CastMember castMember);

	@InheritInverseConfiguration
	CastMember toDomain(CastMemberResource castMemberResource);
}
