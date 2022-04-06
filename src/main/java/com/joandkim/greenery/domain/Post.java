package com.joandkim.greenery.domain;

import lombok.Builder;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_post_author"))
    private Member member;

    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostContent> postContents;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private LocalDateTime regDate;
    private Integer likeNumbers;
    private Integer hits;

    @Builder
    public Post(Member member, String title, List<PostContent> postContents) {
        this.member = member;
        this.title = title;
        this.postContents = postContents;
    }
}
