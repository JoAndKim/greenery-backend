package com.joandkim.greenery.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Posts {

    @JsonProperty("posts")
    private List<PostThumbnailResponse> postThumbnailResponse;

    public Posts(List<PostThumbnailResponse> postThumbnailResponse) {
        this.postThumbnailResponse = postThumbnailResponse;
    }
}
