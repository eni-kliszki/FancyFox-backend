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

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MediaController {
    @Autowired
    private MediaRepository mediaRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Media>> getAllMedia(){
        return ResponseEntity.ok(mediaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedMedia> getMediaById(@PathVariable("id") Long id){
        Media mediaFromDb = mediaRepository.findMediaById(id);
        DetailedMedia detailedMedia = DetailedMedia.builder()
                .id(mediaFromDb.getId())
                .title(mediaFromDb.getTitle())
                .url(mediaFromDb.getUrl())
                .build();
        return ResponseEntity.ok(detailedMedia);
    }
}
