package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.post.BriefPost;
import com.joandkim.greenery.dto.post.EditingPost;
import com.joandkim.greenery.dto.post.NewPost;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.dto.post.detail.PostDetail;
import com.joandkim.greenery.dto.post.main.MainPosts;
import com.joandkim.greenery.mapper.PostMapper;
import com.joandkim.greenery.util.AuthenticationManager;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

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

    // TODO: need to bring memberId
    @Transactional
    public void create(NewPost newPost) {
        postMapper.save(newPost, AuthenticationManager.member().getId());
        postMapper.savePostContents(newPost.getPostContents(), newPost.getId());
    }

    @Transactional
    public void processLike(Long postId) {
        Long memberId = AuthenticationManager.member().getId();
        Boolean liked = postMapper.findLikeByPostIdAndMemberId(postId, memberId);
        if (liked) {
            postMapper.deleteLike(postId, memberId);
        } else {
            postMapper.saveLike(postId, memberId);
        }
    }

    public void edit(Long postId, EditingPost editingPost) {
        Long postMemberId = postMapper.findMemberIdByPostId(postId);
        boolean self = postMemberId.equals(AuthenticationManager.member().getId());
        if (self) {
            postMapper.editPost(postId, editingPost.getTitle());
            postMapper.editPostContents(postId, editingPost.getPostContents());
        } else {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }
}
