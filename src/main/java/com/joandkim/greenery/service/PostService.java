package com.joandkim.greenery.service;

import com.joandkim.greenery.domain.Member;
import com.joandkim.greenery.domain.Post;
import com.joandkim.greenery.dto.post.PostThumbnailResponse;
import com.joandkim.greenery.dto.post.save.PostContentRequest;
import com.joandkim.greenery.dto.post.save.PostForSaveRequest;
import com.joandkim.greenery.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostThumbnailResponse> getPosts() {
        return postRepository.findAll().stream()
                .map(PostThumbnailResponse::from)
                .collect(Collectors.toList());
    }

    public void save(PostForSaveRequest post) {
        Post p = new Post(new Member(1L), // TODO 세션에서 가져올 Member
                post.getTitle(),
                post.getPostContents().stream()
                .map(PostContentRequest::toEntity)
                .collect(Collectors.toList())
        );
        postRepository.save(p);
    }
}
