package com.joandkim.greenery.mapper;

import com.joandkim.greenery.dto.comment.CommentResponse;
import com.joandkim.greenery.dto.comment.SavingCommentRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    void save(@Param("postId") Long postId,
              @Param("request") SavingCommentRequest request,
              @Param("memberId") Long memberId);

    List<CommentResponse> getComments(Long postId);
}
