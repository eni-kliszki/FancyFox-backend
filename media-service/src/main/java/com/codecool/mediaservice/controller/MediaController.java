package com.codecool.mediaservice.controller;

import com.codecool.mediaservice.entity.Media;
import com.codecool.mediaservice.model.CommentModel;
import com.codecool.mediaservice.model.DetailedMedia;
import com.codecool.mediaservice.repository.MediaRepository;
import com.codecool.mediaservice.service.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class MediaController {
    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private DataConverter dataConverter;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public ResponseEntity<List<Media>> getAllMedia() {
        return ResponseEntity.ok(mediaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedMedia> getMediaById(@PathVariable("id") Long id) {
        DetailedMedia detailedMedia = dataConverter.createDetailedMediaById(id);
        return ResponseEntity.ok(detailedMedia);
    }

    @PostMapping("/add-post")
    public ResponseEntity<?> uploadMedia(@RequestBody Media media) {
        try {
            Media savedMedia = mediaRepository.save(media);
            restTemplate.postForEntity("http://ratingservice/rating/add-rating", savedMedia.getId() ,String.class);
            return ResponseEntity.ok("Successfully uploaded");
        } catch (Exception e) {
            return ResponseEntity.ok("Upload failed" + e.getMessage());
        }
    }

    @PostMapping("/add-comment")
    public ResponseEntity<?> uploadComment(@RequestBody CommentModel comment) {
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://commentservice/comment/add", comment, String.class);
        return ResponseEntity.ok(Objects.requireNonNull(stringResponseEntity.getBody()));
    }
}
