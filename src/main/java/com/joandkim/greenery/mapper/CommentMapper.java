package com.joandkim.greenery.mapper;

import com.joandkim.greenery.dto.SavingCommentRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
    void save(@Param("postId") Long postId,
              @Param("request") SavingCommentRequest request,
              @Param("memberId") Long memberId);
}
