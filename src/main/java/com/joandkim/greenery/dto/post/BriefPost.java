package com.joandkim.greenery.dto.post;

import lombok.Getter;

@Getter
public class BriefPost {
    private Long id;
    private BriefUser briefUser;
    private String title;
    private String mainImageUrl;
    private Integer likes;
    private Integer hits;
}
