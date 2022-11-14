package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Rating;
import com.acmeflix.transfer.resource.ContentRatingResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Locale;

@Mapper(componentModel = "spring", imports = {Locale.class})
public interface ContentRatingMapper extends BaseMapper<Rating, ContentRatingResource> {
	@Mapping(target = "contentTitle", source = "content.title")
	@Mapping(target = "rate", expression = "java(String.format(Locale.ENGLISH, \"%.2f\", rating.getRate()))")
	ContentRatingResource toResource(Rating rating);

}
