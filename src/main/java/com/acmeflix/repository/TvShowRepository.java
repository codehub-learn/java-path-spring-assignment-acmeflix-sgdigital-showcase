package com.acmeflix.repository;

import com.acmeflix.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {
	List<TvShow> findByTitleIgnoreCase(String title);

	@Query("""
			select distinct tv
			from TvShow tv
			left join fetch tv.recommendations tvr
			left join fetch tv.ratings
			left join fetch tv.castMembers tvcm
			left join fetch tv.seasons tvs
			left join fetch tvs.episodes tvse
			where tv.id = :id""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	TvShow getFullContent(Long id);

	@Query("""
			select distinct tv
			from TvShow tv
			left join fetch tv.ratings""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	List<TvShow> getRatings();
}
