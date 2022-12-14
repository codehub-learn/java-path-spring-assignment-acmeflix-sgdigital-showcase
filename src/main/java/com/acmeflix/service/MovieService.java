package com.acmeflix.service;

import com.acmeflix.domain.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
	List<Movie> findByTitle(String title);

	List<Movie> getFullContent();

	Movie getFullContent(final Long id);

	List<Movie> getRatings();
}
