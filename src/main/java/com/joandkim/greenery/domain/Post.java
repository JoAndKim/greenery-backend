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

    @ManyToOne
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
}
