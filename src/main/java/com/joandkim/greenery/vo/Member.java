package com.joandkim.greenery.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Member {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String profileImageUrl;
}
