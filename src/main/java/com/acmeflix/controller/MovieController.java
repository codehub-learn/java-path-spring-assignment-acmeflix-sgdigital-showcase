package com.acmeflix.controller;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Movie;
import com.acmeflix.mapper.MovieMapper;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.MovieService;
import com.acmeflix.transfer.resource.MovieResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController extends AbstractController<Movie, MovieResource> {
	private final MovieService movieService;
	private final MovieMapper movieMapper;

	@Override
	public BaseService<Movie, Long> getBaseService() {
		return movieService;
	}

	@Override
	public BaseMapper<Movie, MovieResource> getMapper() {
		return movieMapper;
	}
}
