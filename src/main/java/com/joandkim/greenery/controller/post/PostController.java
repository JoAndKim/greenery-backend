package com.joandkim.greenery.controller.post;

import com.joandkim.greenery.dto.post.PostThumbnailResponse;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.dto.post.save.PostForSaveRequest;
import com.joandkim.greenery.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final Logger logger = LoggerFactory.getLogger(PostController.class.getName());
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<Posts> getPosts() {
        List<PostThumbnailResponse> posts = postService.getPosts();

        return ResponseEntity.ok(new Posts(posts));
    }

    @PostMapping("/posts")
    public ResponseEntity<Void> save(@RequestBody PostForSaveRequest post) {
        logger.info("save request body: {}", post.toString());
        postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
