package com.codecool.mediaservice.repository;

import com.codecool.mediaservice.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    Media findMediaById(Long id);

    List<Media> findAllByOrderByIdDesc();
}
