package com.joandkim.greenery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Like> likes;

    @OneToMany
    private List<Post> posts;

    @OneToMany
    private List<Comment> comments;

    private String username;
    private String password;
    private String email;
    private String profileImageUrl;
}
