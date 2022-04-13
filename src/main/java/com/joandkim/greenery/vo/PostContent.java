package com.joandkim.greenery.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class PostContent {
    private Long id;
    private String postImageUrl;
    private String content;

    @JsonIgnore
    private Long post_id;
}
