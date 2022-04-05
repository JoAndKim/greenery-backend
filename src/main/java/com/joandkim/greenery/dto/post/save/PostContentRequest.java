package com.joandkim.greenery.dto.post.save;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostContentRequest {
    private String postImageUrl;
    private String content;
}
