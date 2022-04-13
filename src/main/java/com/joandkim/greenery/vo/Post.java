package com.joandkim.greenery.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private Long id;
    private String title;
    private LocalDateTime regDate;
    private Integer likeNumbers;
    private Integer hits;
    private Long memberId;
}
