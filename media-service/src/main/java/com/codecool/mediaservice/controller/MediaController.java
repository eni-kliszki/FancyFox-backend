package com.codecool.mediaservice.controller;

import com.codecool.mediaservice.entity.Media;
import com.codecool.mediaservice.model.DetailedMedia;
import com.codecool.mediaservice.repository.MediaRepository;
import com.codecool.mediaservice.service.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MediaController {
    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private DataConverter dataConverter;

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
    public ResponseEntity<?> uploadMedia(@RequestBody Media media){
        try{
            mediaRepository.save(media);
            return ResponseEntity.ok("Successfully uploaded");
        }catch(Exception e){
            return ResponseEntity.ok("Upload failed" + e.getMessage());
        }
    }

}
