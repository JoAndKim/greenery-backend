package com.joandkim.greenery.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private Long id;
    private Long group_id;
    private Long post_id;
    private Integer level;
    private Long member_id;
    private String content;
    private LocalDateTime regDate;
}
