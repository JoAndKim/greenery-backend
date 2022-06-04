package com.joandkim.greenery.dto.post;

import com.joandkim.greenery.vo.PostContent;
import lombok.Getter;

import java.util.List;

@Getter
public class EditingPost {
    private String title;
    private List<PostContent> postContents;
}
