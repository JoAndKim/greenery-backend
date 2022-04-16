package com.joandkim.greenery.controller.post;

import com.joandkim.greenery.dto.post.NewPost;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.dto.post.detail.PostDetail;
import com.joandkim.greenery.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity posts() {
        Posts posts = postService.getPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity postDetail(@PathVariable Long postId) {
        PostDetail postDetail = postService.getPostDetail(postId);
        return ResponseEntity.ok(postDetail);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody NewPost newPost) {
        System.out.println(newPost);
        postService.create(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
