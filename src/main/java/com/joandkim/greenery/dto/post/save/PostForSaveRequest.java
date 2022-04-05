package com.joandkim.greenery.dto.post.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostForSaveRequest {
    private String title;

    @JsonProperty("postContent")
    private List<PostContentRequest> postContents;
}
