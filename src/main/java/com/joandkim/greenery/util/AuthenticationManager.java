package com.joandkim.greenery.util;

import com.joandkim.greenery.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class AuthenticationManager {

    public static Long memberId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("Principal: {}", principal);
        if (principal instanceof Member) {
            return ((Member) principal).getId();
        } else {
            // TODO: need a fix
            return null;
        }
    }
}
