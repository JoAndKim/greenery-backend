package com.joandkim.greenery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_post_author"))
    private Member member;

    private String title;

    @OneToMany(mappedBy = "post")
    private List<PostContent> postContents;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    private LocalDateTime regDate;
    private Integer likeNumbers;
    private Integer hits;
}
