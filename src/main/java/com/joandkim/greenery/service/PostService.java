package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.post.BriefPost;
import com.joandkim.greenery.dto.post.EditingPost;
import com.joandkim.greenery.dto.post.NewPost;
import com.joandkim.greenery.dto.post.Posts;
import com.joandkim.greenery.dto.post.detail.PostDetail;
import com.joandkim.greenery.dto.post.main.MainPosts;
import com.joandkim.greenery.mapper.PostMapper;
import com.joandkim.greenery.util.AuthenticationManager;
import com.joandkim.greenery.vo.PostContent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Posts getPosts(String search) {
        List<BriefPost> posts;
        if (search != null) {
            posts = postMapper.getBriefPostForSearch(search);
        } else {
            posts = postMapper.getBriefPost();
        }
        logger.info("posts: {}", posts);
        return new Posts(posts);
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
    public Long create(NewPost newPost) {
        postMapper.save(newPost, AuthenticationManager.member().getId());
        postMapper.savePostContents(newPost.getPostContents(), newPost.getId());
        return newPost.getId();
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
        if (isAuthor(postId)) {
            postMapper.editPost(postId, editingPost.getTitle());
            for (PostContent pc : editingPost.getPostContents()) {
                postMapper.editPostContents(postId, pc);
            }
        } else {
            throw new AccessDeniedException(HttpStatus.FORBIDDEN.toString());
        }
    }

    public void delete(Long postId) {
        if (isAuthor(postId)) {
            postMapper.deletePost(postId);
            postMapper.deletePostContents(postId);
        } else {
            throw new AccessDeniedException(HttpStatus.FORBIDDEN.toString());
        }
    }


    @Transactional
    public Posts getMyLikesPosts(Long userId) {
        if (isSameUser(userId)) {
            List<Long> postIds = postMapper.getPostIdsByUserId(userId);
            List<BriefPost> posts = postMapper.getMyLikesPosts(postIds);
            return new Posts(posts);
        } else {
            throw new AccessDeniedException(HttpStatus.FORBIDDEN.toString());
        }
    }

    public Posts getMyPosts() {
        Long userId = AuthenticationManager.member().getId();
        List<BriefPost> posts = postMapper.getMyPosts(userId);
        return new Posts(posts);
    }

    private boolean isSameUser(Long userId) {
        return userId.equals(AuthenticationManager.member().getId());
    }

    private boolean isAuthor(Long postId) {
        Long postMemberId = postMapper.findMemberIdByPostId(postId);
        return postMemberId.equals(AuthenticationManager.member().getId());
    }


}
