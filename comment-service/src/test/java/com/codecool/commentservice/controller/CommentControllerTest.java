package com.codecool.commentservice.controller;

import com.codecool.commentservice.entity.Comment;
import com.codecool.commentservice.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@ActiveProfiles("test")
@SpringBootTest
class CommentControllerTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentController commentController;

    @Test
    public void getCommentByMediaId() {
        Comment comment = Comment.builder()
                .comment("Much doge")
                .mediaId(1L)
                .build();

        commentRepository.save(comment);

        String commentString = commentController.getCommentByMediaId("1").getBody().get(0).getComment();

        assertEquals("Much doge", commentString);
    }

}