package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	@Query("""
			select distinct acc
			from Account acc
			left join fetch acc.creditCards cc
			left join fetch acc.profiles p
			left join fetch p.ratings r""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	List<Account> getFullContent();

	@Query("""
			select distinct acc
			from Account acc
			left join fetch acc.creditCards cc
			left join fetch acc.profiles p
			left join fetch p.ratings r
			where acc.id = :id""")
	@QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	Account getFullContent(Long id);
}
