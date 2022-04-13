package com.joandkim.greenery.dto.post.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joandkim.greenery.dto.post.BriefMember;
import com.joandkim.greenery.vo.PostContent;
import lombok.Getter;

import java.util.List;

@Getter
public class PostDetail {
    private Long id;

    @JsonProperty("user")
    private BriefMember briefMember;

    private String title;
    private Integer likes;
    private Boolean likeStatus;
    private List<PostContent> postContents;
    private String regDate;
}
