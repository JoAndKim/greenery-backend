package com.joandkim.greenery.service.member;

import com.joandkim.greenery.util.JwtTokenProvider;
import com.joandkim.greenery.dto.member.LoginMember;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;

    public String login(LoginMember loginMember) {
        Member member = memberService.loadUserByUsername(loginMember.getUsername());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(loginMember.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return jwtTokenProvider.createToken(member.getUsername());
    }
}

