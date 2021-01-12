package com.codecool.ratingservice.controller;


import com.codecool.ratingservice.entity.Rating;
import com.codecool.ratingservice.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@Slf4j
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService service;

    @GetMapping("/{videoId}")
    public Long getRatingByVideoId(@PathVariable("videoId") Long id) {
        return service.getRatingByVideoId(id);
    }

    @PutMapping("/{videoId}")
    public Long updateRating(@PathVariable("videoId") Long id) {
        return service.increaseRatingByVideoId(id);
    }

    @PostMapping("/{videoId}")
    public String addRatingByVideoId(@PathVariable("videoId") Long id) {
        boolean success = service.addNewRating(id);
        String msg = "OK";
        if (!success) {
            msg = "Not OK";
        }
        return msg;
    }
}
