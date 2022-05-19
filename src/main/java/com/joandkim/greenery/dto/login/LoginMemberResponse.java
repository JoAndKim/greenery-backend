package com.joandkim.greenery.dto.login;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginMemberResponse {
    private String accessToken;
    private String refreshToken;
    private String nickname;
    private String profileImageUrl;
}
