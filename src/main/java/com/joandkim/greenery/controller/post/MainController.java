package com.joandkim.greenery.controller.post;

import com.joandkim.greenery.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "메인 글 3개", description = "인기글 3개 호출")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "호출 성공")
    })
    @GetMapping
    public ResponseEntity main() {
        return ResponseEntity.ok(postService.getMainPosts());
    }
}
