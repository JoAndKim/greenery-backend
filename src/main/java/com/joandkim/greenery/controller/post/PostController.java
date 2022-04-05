package com.joandkim.greenery.controller.post;

import com.joandkim.greenery.dto.post.PostThumbnailResponse;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<Posts> getPosts() {
        List<PostThumbnailResponse> posts = postService.getPosts();

        return ResponseEntity.ok(new Posts(posts));
    }
}
