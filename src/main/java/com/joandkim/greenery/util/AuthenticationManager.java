package com.joandkim.greenery.util;

import com.joandkim.greenery.vo.Member;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationManager {

    public static Member member() {
        return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
