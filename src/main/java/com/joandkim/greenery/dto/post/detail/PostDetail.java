package com.joandkim.greenery.dto.post.detail;

import com.joandkim.greenery.dto.post.BriefMember;
import com.joandkim.greenery.vo.PostContent;
import lombok.Getter;

import java.util.List;

@Getter
public class PostDetail {
    private Long id;
    private BriefMember briefMember;
    private String title;
    private Integer likes;
    private Boolean likeStatus;
    private List<PostContent> postContents;
    private String regDate;
}
