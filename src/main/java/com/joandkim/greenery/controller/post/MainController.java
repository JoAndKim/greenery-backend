package com.joandkim.greenery.controller.post;

import com.joandkim.greenery.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main")
public class MainController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity main() {
        return ResponseEntity.ok(postService.getMainPosts());
    }
}
