package com.joandkim.greenery.service;

import com.joandkim.greenery.dto.SavingCommentRequest;
import com.joandkim.greenery.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public void saveComment(Long postId, SavingCommentRequest request) {
        commentMapper.save(postId, request);
    }
}
