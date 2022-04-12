package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.post.PostThumbnailResponse;
import com.joandkim.greenery.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    public List<PostThumbnailResponse> getPosts() {
        return postMapper.findAll().stream()
                .map(PostThumbnailResponse::from)
                .collect(Collectors.toList());
    }
}
