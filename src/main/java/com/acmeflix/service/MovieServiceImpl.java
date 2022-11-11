package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
	private final MovieRepository movieRepository;

	@Override
	public JpaRepository<Movie, Long> getRepository() {
		return movieRepository;
	}

	@Override
	public List<Movie> findByTitle(final String title) {
		return movieRepository.findByTitleIgnoreCase(title);
	}

	@Override
	public Movie getFullContent(final Long id) {
		return movieRepository.getFullContent(id);
	}

	@Override
	public List<Movie> getRatings() {
		return movieRepository.getRatings();
	}
}
