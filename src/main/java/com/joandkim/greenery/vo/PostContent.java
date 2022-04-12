package com.joandkim.greenery.vo;

import lombok.Getter;

@Getter
public class PostContent {
    private Long id;
    private String postImageUrl;
    private String content;
    private Post post;
}
