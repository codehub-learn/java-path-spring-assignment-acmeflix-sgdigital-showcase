package com.acmeflix.service;

import com.acmeflix.domain.Episode;
import com.acmeflix.domain.Season;
import com.acmeflix.domain.TvShow;
import com.acmeflix.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService {
	private final TvShowRepository tvShowRepository;

	@Override
	public JpaRepository<TvShow, Long> getRepository() {
		return tvShowRepository;
	}

	@Override
	public void addSeasons(final TvShow tvShow, final Season... seasons) {
		Arrays.stream(seasons).forEach(s -> {
			s.setTvShow(tvShow);
			tvShow.getSeasons().add(s);
		});
	}

	@Override
	public void addEpisodes(final Season season, final Episode... episodes) {
		Arrays.stream(episodes).forEach(e -> {
			e.setSeason(season);
			season.getEpisodes().add(e);
		});
	}

	@Override
	public List<TvShow> findByTitle(final String title) {
		return tvShowRepository.findByTitleIgnoreCase(title);
	}

	@Override
	public Season getSeason(final TvShow tvShow, Integer ordering) {
		return tvShow.getSeasons().stream().filter(s -> s.getOrdering() == ordering).findFirst().orElseThrow();
	}

	@Override
	public List<TvShow> findAll() {
		return getFullContent();
	}

	@Override
	public List<TvShow> getFullContent() {
		return tvShowRepository.getFullContent();
	}

	@Override
	public TvShow getFullContent(final Long id) {
		return tvShowRepository.getFullContent(id);
	}

	@Override
	public List<TvShow> getRatings() {
		return tvShowRepository.getRatings();
	}
}
