package com.codecool.commentservice.controller;

import com.codecool.commentservice.entity.Comment;
import com.codecool.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("{id}")
    public ResponseEntity<List<String>> getCommentByMediaId(@PathVariable String id) {
        Long longId = Long.parseLong(id);
        List<Comment> comments = commentRepository.findAllByMediaId(longId);
        List<String> commentMessages = new ArrayList<>();
        comments.forEach(comment -> commentMessages.add(comment.getComment()));
        return ResponseEntity.ok(commentMessages);
    }

    @PostMapping("add")
    public void addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
    }
}
