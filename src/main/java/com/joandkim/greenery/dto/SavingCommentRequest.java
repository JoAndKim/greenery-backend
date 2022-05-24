package com.joandkim.greenery.dto;

import lombok.Getter;

@Getter
public class SavingCommentRequest {
    private String content;
    private Integer layer;
    private Integer groupId;
}
