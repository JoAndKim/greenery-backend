package com.joandkim.greenery.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PostContent {

    @Id
    @GeneratedValue
    private Long id;

    private String postImageUrl;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_post_content"))
    private Post post;
}
