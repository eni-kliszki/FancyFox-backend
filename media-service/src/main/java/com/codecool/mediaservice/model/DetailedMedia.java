package com.codecool.mediaservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailedMedia {
    private Long id;
    private String title;
    private String url;
    private Long rating;
    private List<String> comments;
}
