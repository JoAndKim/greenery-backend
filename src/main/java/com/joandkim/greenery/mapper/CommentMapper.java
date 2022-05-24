package com.joandkim.greenery.mapper;

import com.joandkim.greenery.dto.SavingCommentRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    void save(Long postId, SavingCommentRequest request);
}
