package com.joandkim.greenery.dto.post;

import com.joandkim.greenery.domain.Post;
import lombok.Builder;

@Builder
public class PostThumbnailResponse {
    private Long id;
    private UserInfoForPostThumbnail userInfoForPostThumbnail;
    private String title;
    private String mainImageUrl;
    private Integer likes;
    private Integer hits;

    public static PostThumbnailResponse toEntity(Post post) {
        return PostThumbnailResponse.builder()
                .id(post.getId())
                .userInfoForPostThumbnail(new UserInfoForPostThumbnail(post.getMember().getUsername(), post.getMember().getProfileImageUrl()))
                .title(post.getTitle())
                .mainImageUrl(post.getPostContents().get(0).getPostImageUrl())
                .likes(post.getLikeNumbers())
                .hits(post.getHits())
                .build();
    }
}
