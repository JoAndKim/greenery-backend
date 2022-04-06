package com.joandkim.greenery.dto.post.save;

import com.joandkim.greenery.domain.PostContent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostContentRequest {
    private String postImageUrl;
    private String content;

    public PostContent toEntity() {
        return PostContent.builder()
                .postImageUrl(this.postImageUrl)
                .content(this.content)
                .build();
    }
}
