package com.codecool.mediaservice.controller;

import com.codecool.mediaservice.entity.Media;
import com.codecool.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MediaController {
    @Autowired
    private MediaRepository mediaRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Media>> getAllMedia(){
        return ResponseEntity.ok(mediaRepository.findAll());
    }
}
