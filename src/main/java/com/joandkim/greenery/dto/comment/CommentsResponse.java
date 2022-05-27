package com.joandkim.greenery.dto.comment;

import lombok.Getter;

import java.util.List;

@Getter
public class CommentsResponse {
    private List<CommentResponse> comments;
}
