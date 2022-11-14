package com.acmeflix.mapper;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Movie;
import com.acmeflix.domain.Rating;
import com.acmeflix.transfer.resource.MovieResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Locale;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {CastMemberMapper.class, ContentRatingMapper.class})
public interface MovieMapper extends BaseMapper<Movie, MovieResource> {
	@Mapping(target = "rate", source = "ratings", qualifiedByName = "averageRate")
	MovieResource toResource(Movie movie);

	@Named("averageRate")
	default String averageRate(Set<Rating> ratings) {
		return String.format(Locale.ENGLISH, "%.2f", ratings.stream().mapToDouble(Rating::getRate).average()
															.getAsDouble());
	}
}
