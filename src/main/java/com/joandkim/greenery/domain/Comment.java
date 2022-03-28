package com.joandkim.greenery.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private Long groupId;

    @ManyToOne
    private Post post;

    private Integer level;

    @ManyToOne
    private User user;

    private String content;

    private LocalDateTime regDate;
}
