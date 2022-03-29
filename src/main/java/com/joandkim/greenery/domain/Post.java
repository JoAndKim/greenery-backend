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
    private User user;

    private String title;

    @OneToMany
    private List<PostContent> postContents;

    @OneToMany
    private List<Comment> comments;

    private LocalDateTime regDate;
    private Integer likes;
    private Integer hits;
}
