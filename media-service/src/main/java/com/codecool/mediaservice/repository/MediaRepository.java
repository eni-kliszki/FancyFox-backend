package com.codecool.mediaservice.repository;

import com.codecool.mediaservice.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
