package com.joandkim.greenery.dto.post;

import lombok.Getter;

import java.util.List;

@Getter
public class Posts {
    private List<BriefPost> posts;

    public Posts(List<BriefPost> posts) {
        this.posts = posts;
    }
}
