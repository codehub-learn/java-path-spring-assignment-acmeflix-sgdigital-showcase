package com.acmeflix.repository;

import com.acmeflix.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	@Query("""
			select distinct p
			from Person p
			left join fetch p.castMembers pcm""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	List<Person> getFullContent();

	@Query("""
			select distinct p
			from Person p
			left join fetch p.castMembers pcm
			where p.id = :id""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	Person getFullContent(Long id);

	List<Person> findByLastNameIgnoreCaseAndFirstNameIgnoreCase(String lastName, String firstName);
}
