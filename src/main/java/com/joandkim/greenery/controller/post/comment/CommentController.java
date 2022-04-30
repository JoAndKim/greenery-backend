package com.joandkim.greenery.controller.post.comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Void> saveComment(@PathVariable Long postId) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
