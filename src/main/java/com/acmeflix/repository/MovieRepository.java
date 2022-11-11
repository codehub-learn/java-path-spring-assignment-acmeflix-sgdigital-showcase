package com.acmeflix.repository;

import com.acmeflix.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTitleIgnoreCase(String title);

	@Query("""
			select distinct m
			from Movie m
			left join fetch m.recommendations mr
			left join fetch m.castMembers mcm
			left join fetch m.ratings 
			where m.id = :id""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	Movie getFullContent(Long id);

	@Query("""
			select distinct m
			from Movie m
			left join fetch m.ratings""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	List<Movie> getRatings();
}
