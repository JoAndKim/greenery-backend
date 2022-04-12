package com.joandkim.greenery.controller.post;

import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<Posts> posts() {
        Posts posts = postService.getPosts();
        return ResponseEntity.ok(posts);
    }
}
