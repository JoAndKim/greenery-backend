package com.joandkim.greenery.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joandkim.greenery.dto.BriefMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BriefPost {
    private Long id;

    @JsonProperty("user")
    private BriefMember briefMember;

    private String title;
    private String mainImageUrl;
    private Integer likes;
    private Integer hits;

    public void setBriefMember(BriefMember briefMember) {
        this.briefMember = briefMember;
    }
}
