package com.joandkim.greenery.dto.post;

import lombok.Getter;

@Getter
public class UserInfoForPostThumbnail {
    private String username;
    private String profileImageUrl;

    public UserInfoForPostThumbnail(String username, String profileImageUrl) {
        this.username = username;
        this.profileImageUrl = profileImageUrl;
    }
}
