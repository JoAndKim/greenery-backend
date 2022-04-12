package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.post.BriefPost;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    public Posts getPosts() {
        List<BriefPost> post = postMapper.getBriefPost();
        // TODO: get full post incuding BriefMember and return Posts
        return null;
    }
}
