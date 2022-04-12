package com.joandkim.greenery.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post {
    private Long id;
    private Member member;
    private String title;
    private List<PostContent> postContents;
    private List<Comment> comments;
    private LocalDateTime regDate;
    private Integer likeNumbers;
    private Integer hits;
}
