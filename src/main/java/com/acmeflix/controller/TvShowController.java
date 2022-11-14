package com.acmeflix.controller;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.TvShow;
import com.acmeflix.mapper.TvShowMapper;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.TvShowService;
import com.acmeflix.transfer.resource.TvShowResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tvshows")
public class TvShowController extends AbstractController<TvShow, TvShowResource> {
	private final TvShowService tvShowService;
	private final TvShowMapper tvShowMapper;

	@Override
	public BaseService<TvShow, Long> getBaseService() {
		return tvShowService;
	}

	@Override
	public BaseMapper<TvShow, TvShowResource> getMapper() {
		return tvShowMapper;
	}
}
