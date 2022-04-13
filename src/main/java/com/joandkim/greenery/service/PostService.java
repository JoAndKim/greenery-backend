package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.post.BriefPost;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.dto.post.detail.PostDetail;
import com.joandkim.greenery.dto.post.main.MainPosts;
import com.joandkim.greenery.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Posts getPosts() {
        List<BriefPost> post = postMapper.getBriefPost();
        logger.info("post: {}", post);
        return new Posts(post);
    }

    public MainPosts getMainPosts() {
        List<BriefPost> briefPost = postMapper.getBriefPost(true);
        return new MainPosts(briefPost);
    }

    public PostDetail getPostDetail(Long postId) {
        return postMapper.getPostDetail(postId);
    }
}
