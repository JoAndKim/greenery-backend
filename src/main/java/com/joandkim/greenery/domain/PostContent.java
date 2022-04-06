package com.joandkim.greenery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PostContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postImageUrl;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_post_content"))
    private Post post;

    @Builder
    public PostContent(String postImageUrl, String content) {
        this.postImageUrl = postImageUrl;
        this.content = content;
    }
}
