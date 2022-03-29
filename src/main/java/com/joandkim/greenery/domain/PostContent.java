package com.joandkim.greenery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class PostContent {

    @Id
    @GeneratedValue
    private Long id;

    private String postImageUrl;
    private String content;

    @ManyToOne
    private Post post;
}
