package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.comment.SavingCommentRequest;
import com.joandkim.greenery.mapper.CommentMapper;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public void saveComment(Long postId, SavingCommentRequest request) {
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentMapper.save(postId, request, member.getId());
    }
}
