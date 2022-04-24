package com.joandkim.greenery.dto.post;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BriefMember {
    private Long userId;
    private String nickname;
    private String profileImageUrl;
}
