package com.joandkim.greenery.dto.post;

import com.joandkim.greenery.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostThumbnailResponse {
    private Long id;
    private UserInfoForPostThumbnail userInfoForPostThumbnail;
    private String title;
    private String mainImageUrl;
    private Integer likes;
    private Integer hits;

    public static PostThumbnailResponse from(Post post) {
        return PostThumbnailResponse.builder()
                .id(post.getId())
                .userInfoForPostThumbnail(new UserInfoForPostThumbnail(post.getMember().getUsername(), post.getMember().getProfileImageUrl()))
                .title(post.getTitle())
                .mainImageUrl(null)
                .likes(post.getLikeNumbers())
                .hits(post.getHits())
                .build();
    }
}
