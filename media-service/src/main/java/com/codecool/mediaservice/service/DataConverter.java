package com.codecool.mediaservice.service;

import com.codecool.mediaservice.entity.Media;
import com.codecool.mediaservice.model.DetailedMedia;
import com.codecool.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataConverter {
    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public DetailedMedia createDetailedMediaById(Long id) {
        Media mediaFromDb = mediaRepository.findMediaById(id);
        String[] commentsFromService = restTemplate.getForEntity("http://localhost:8090/comment/" + id, String[].class).getBody();
        List<String> comments = new ArrayList<>();
        if (commentsFromService != null) {
            comments.addAll(Arrays.asList(commentsFromService));
        }
        Integer rating = restTemplate.getForEntity("http://localhost:8070/rating/" + id, Integer.class).getBody();

        DetailedMedia detailedMedia = DetailedMedia.builder()
                .id(mediaFromDb.getId())
                .title(mediaFromDb.getTitle())
                .url(mediaFromDb.getUrl())
                .build();
        detailedMedia.setComments(comments);
        if (rating != null) {
            detailedMedia.setRating(rating.longValue());
        }
        return detailedMedia;
    }
}
