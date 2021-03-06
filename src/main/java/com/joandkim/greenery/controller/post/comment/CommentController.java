package com.joandkim.greenery.controller.post.comment;

import com.joandkim.greenery.dto.comment.CommentsResponse;
import com.joandkim.greenery.dto.comment.SavingCommentRequest;
import com.joandkim.greenery.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{postId}/comments")
    public ResponseEntity<CommentsResponse> getComments(@PathVariable Long postId) {
        CommentsResponse commentsResponse = commentService.getComments(postId);
        return ResponseEntity.ok(commentsResponse);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Void> saveComment(@PathVariable Long postId,
                                            @RequestBody SavingCommentRequest request) {
        commentService.saveComment(postId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
