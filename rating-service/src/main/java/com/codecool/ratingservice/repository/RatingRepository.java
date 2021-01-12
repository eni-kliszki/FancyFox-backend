package com.codecool.ratingservice.repository;

import com.codecool.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
