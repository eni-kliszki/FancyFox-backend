package com.codecool.commentservice.controller;

import com.codecool.commentservice.entity.Comment;
import com.codecool.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("{id}")
    public ResponseEntity<List<Comment>> getCommentByMediaId(@PathVariable String id) {
        Long longId = Long.parseLong(id);
        List<Comment> comments = commentRepository.findAllByMediaId(longId);

        return ResponseEntity.ok(comments);
    }

    @PostMapping("add")
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        try{
            commentRepository.save(comment);
            return ResponseEntity.ok("Comment saved successfully");
        }catch (Exception e){
            return ResponseEntity.ok("Saving comment failed:" + e.getMessage());
        }
    }
}
