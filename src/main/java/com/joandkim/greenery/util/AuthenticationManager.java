package com.joandkim.greenery.util;

import com.joandkim.greenery.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class AuthenticationManager {

    public static Member member() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("Principal: {}", principal);
        return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
