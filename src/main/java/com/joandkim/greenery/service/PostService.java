package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.post.PostThumbnailResponse;
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
                .map(PostThumbnailResponse::toEntity)
                .collect(Collectors.toList());
    }
}
