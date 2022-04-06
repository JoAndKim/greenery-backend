package com.joandkim.greenery.dto.post.save;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostForSaveRequest {
    private String title;

    @JsonProperty("postContent")
    private List<PostContentRequest> postContents;
}
