package com.joandkim.greenery.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BriefPost {
    private Long id;
    private BriefMember briefMember;
    private String title;
    private String mainImageUrl;
    private Integer likes;
    private Integer hits;

    public void setBriefMember(BriefMember briefMember) {
        this.briefMember = briefMember;
    }
}
