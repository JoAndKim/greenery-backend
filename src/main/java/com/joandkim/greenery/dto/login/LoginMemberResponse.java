package com.joandkim.greenery.dto.login;

import lombok.Getter;

@Getter
public class LoginMemberResponse {
    private String accessToken;
    private String nickname;
    private String profileImageUrl;
}
