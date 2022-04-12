package com.joandkim.greenery.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<LikeNumber> likeNumbers;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private String username;
    private String password;
    private String email;
    private String profileImageUrl;
}
