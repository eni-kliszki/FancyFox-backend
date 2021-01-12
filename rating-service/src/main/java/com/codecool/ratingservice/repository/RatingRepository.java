package com.codecool.ratingservice.repository;

import com.codecool.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    Rating getByVideoId(Long videoId);


    @Transactional
    @Modifying
    @Query("UPDATE Rating SET ratingNumber = :ratingNumber WHERE videoId = :videoId")
    void updateRatingNumberByVideoId(Long videoId, Long ratingNumber);
}
