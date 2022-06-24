package com.joandkim.greenery.controller.post;

import com.joandkim.greenery.dto.post.EditingPost;
import com.joandkim.greenery.dto.post.NewPost;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.dto.post.detail.PostDetail;
import com.joandkim.greenery.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Operation(summary = "글 목록", description = "글 목록을 호출한다")
    @GetMapping
    public ResponseEntity posts(@RequestParam(required = false) String search) {
        Posts posts = postService.getPosts(search);
        return ResponseEntity.ok(posts);
    }

    @Operation(summary = "글 상세", description = "글 상세를 호출한다. JWT를 헤더에 넣으면 해당 회원에대한 likeStatus같이 응답한다. (미구현)")
    @GetMapping("/{postId}")
    public ResponseEntity postDetail(@PathVariable Long postId) {
        PostDetail postDetail = postService.getPostDetail(postId);
        return ResponseEntity.ok(postDetail);
    }

    @Operation(summary = "글 생성", description = "성공적으로 회원가입하면 JWT를 발급받는다")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "글 생성 성공")
    })
    @PostMapping
    public ResponseEntity create(@RequestBody NewPost newPost) {
        System.out.println(newPost);
        Long postId = postService.create(newPost);
        return ResponseEntity.ok(postId);
    }

    @PostMapping("/{postId}/likes")
    public ResponseEntity like(@PathVariable Long postId) {
        postService.processLike(postId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity edit(@PathVariable Long postId,
                               @RequestBody EditingPost editingPost) {
        postService.edit(postId, editingPost);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity delete(@PathVariable Long postId) {
        postService.delete(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/me/likes")
    public ResponseEntity<Posts> getMyLikesPosts() {
        Posts posts = postService.getMyLikesPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/me")
    public ResponseEntity<Posts> getMyPosts() {
        Posts posts = postService.getMyPosts();
        return ResponseEntity.ok(posts);
    }
}
