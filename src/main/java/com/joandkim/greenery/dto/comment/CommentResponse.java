package com.joandkim.greenery.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
}
