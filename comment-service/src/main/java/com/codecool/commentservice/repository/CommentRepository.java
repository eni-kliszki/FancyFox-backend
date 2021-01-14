package com.codecool.commentservice.repository;

import com.codecool.commentservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByMediaId(Long id);
}
