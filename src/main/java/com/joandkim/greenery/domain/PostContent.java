package com.joandkim.greenery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PostContent {

    @Id
    @GeneratedValue
    private Long id;

    private String postImageUrl;
    private String content;

    @ManyToOne
    private Post post;
}
