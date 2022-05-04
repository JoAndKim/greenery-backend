package com.joandkim.greenery.service.member;

import com.joandkim.greenery.config.jwt.JwtTokenProvider;
import com.joandkim.greenery.dto.login.LoginMemberRequest;
import com.joandkim.greenery.dto.login.LoginMemberResponse;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;

    public LoginMemberResponse login(LoginMemberRequest loginMemberRequest) {
        Member member = memberService.loadUserByUsername(loginMemberRequest.getUsername());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(loginMemberRequest.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return LoginMemberResponse.builder()
                .accessToken(jwtTokenProvider.createToken(member.getUsername()))
                .nickname(member.getNickname())
                .profileImageUrl(member.getProfileImageUrl())
                .build();
    }
}

