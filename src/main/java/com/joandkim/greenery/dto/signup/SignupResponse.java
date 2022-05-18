package com.joandkim.greenery.dto.signup;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupResponse {
    private String accessToken;
    private String refreshToken;
    private String nickname;
    private String profileImageUrl;
}
