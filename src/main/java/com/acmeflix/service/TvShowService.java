package com.acmeflix.service;

import com.acmeflix.domain.Episode;
import com.acmeflix.domain.Season;
import com.acmeflix.domain.TvShow;

import java.util.List;

public interface TvShowService extends BaseService<TvShow, Long> {
	void addSeasons(TvShow tvShow, Season... seasons);

	void addEpisodes(Season season, Episode... episodes);

	List<TvShow> findByTitle(String title);

	Season getSeason(final TvShow tvShow, Integer ordering);

	TvShow getFullContent(Long id);

	List<TvShow> getRatings();
}
