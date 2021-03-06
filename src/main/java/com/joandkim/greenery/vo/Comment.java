package com.joandkim.greenery.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private Long id;
    private Long groupId;
    private Long postId;
    private Integer level;
    private Long memberId;
    private String content;
    private LocalDateTime regDate;
}
