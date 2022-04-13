package com.joandkim.greenery.dto.post;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BriefMember {
    private Long memberId;
    private String username;
    private String profileImageUrl;
}
