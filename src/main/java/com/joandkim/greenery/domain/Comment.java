package com.joandkim.greenery.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private Long groupId;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_comment"))
    private Post post;

    private Integer level;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_comment_author"))
    private Member member;

    private String content;

    private LocalDateTime regDate;
}
