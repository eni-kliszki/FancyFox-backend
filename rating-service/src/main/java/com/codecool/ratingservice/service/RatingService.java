package com.codecool.ratingservice.service;

import com.codecool.ratingservice.entity.Rating;
import com.codecool.ratingservice.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RatingService {

    @Autowired
    private RatingRepository repo;


    public boolean addNewRating(Long videoId) {
        boolean success = true;
        try {
            repo.save(Rating.builder()
                    .ratingNumber((long) 0)
                    .videoId(videoId)
                    .build());
        } catch (DataIntegrityViolationException e) {
            success = false;
        }
        return success;
    }


    public Long getRatingByVideoId(Long videoId) {
        return repo.getByVideoId(videoId).getRatingNumber();
    }

    public Long increaseRatingByVideoId(Long videoId) {
        Long ratingNumber = repo.getByVideoId(videoId).getRatingNumber() + 1;
        repo.updateRatingNumberByVideoId(videoId, ratingNumber);
        return ratingNumber;
    }


}
