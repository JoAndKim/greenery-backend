package com.joandkim.greenery.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class LikeNumber {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_like_user"))
    private Member member;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_like_post"))
    private Post post;
}
