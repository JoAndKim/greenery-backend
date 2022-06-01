package com.joandkim.greenery.dto.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joandkim.greenery.dto.BriefMember;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class CommentResponse {
    private Long id;
    private Integer groupId;
    private Integer postId;
    private Integer layer;

    @JsonProperty("user")
    private BriefMember briefMember;

    private String content;
    private LocalDateTime regDate;
}
