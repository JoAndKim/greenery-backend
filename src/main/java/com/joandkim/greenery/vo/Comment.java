package com.joandkim.greenery.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private Long id;
    private Long groupId;
    private Post post;
    private Integer level;
    private Member member;
    private String content;
    private LocalDateTime regDate;
}
