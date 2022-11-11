package com.acmeflix.repository;

import com.acmeflix.domain.Rating;
import com.acmeflix.domain.composite.RatingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingKey> {
}
