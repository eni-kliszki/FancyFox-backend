package com.codecool.mediaservice.controller;

import com.codecool.mediaservice.entity.Media;
import com.codecool.mediaservice.model.DetailedMedia;
import com.codecool.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class MediaController {
    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public ResponseEntity<List<Media>> getAllMedia() {
        return ResponseEntity.ok(mediaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedMedia> getMediaById(@PathVariable("id") Long id) {
        Media mediaFromDb = mediaRepository.findMediaById(id);
        String[] commentsFromService = restTemplate.getForEntity("http://localhost:8090/comment/" + id, String[].class).getBody();
        List<String> comments = new ArrayList<>();
        if(commentsFromService != null){
            comments.addAll(Arrays.asList(commentsFromService));
        }
        Integer rating = restTemplate.getForEntity("http://localhost:8070/rating/" + id, Integer.class).getBody();

        DetailedMedia detailedMedia = DetailedMedia.builder()
                .id(mediaFromDb.getId())
                .title(mediaFromDb.getTitle())
                .url(mediaFromDb.getUrl())
                .build();
        detailedMedia.setComments(comments);
        if(rating != null){
            detailedMedia.setRating(rating.longValue());
        }

        return ResponseEntity.ok(detailedMedia);
    }
}
