package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Rating;
import com.acmeflix.domain.TvShow;
import com.acmeflix.transfer.resource.TvShowResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Locale;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {CastMemberMapper.class, ContentRatingMapper.class})
public interface TvShowMapper extends BaseMapper<TvShow, TvShowResource> {
	@Mapping(target = "rate", source = "ratings", qualifiedByName = "averageRate")
	TvShowResource toResource(TvShow tvShow);

	@Named("averageRate")
	default String averageRate(Set<Rating> ratings) {
		return String.format(Locale.ENGLISH, "%.2f", ratings.stream().mapToDouble(Rating::getRate).average()
															.getAsDouble());
	}
}
