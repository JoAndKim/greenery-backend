package com.joandkim.greenery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewAccessMemberResponse {
    private String accessToken;
    private String refreshToken;
    private String refreshTokenExpiryDate;
    private String nickname;
    private String profileImageUrl;
}
