package com.joandkim.greenery.service.member;

import com.joandkim.greenery.config.jwt.JwtTokenProvider;
import com.joandkim.greenery.dto.signup.CheckedDuplicatedName;
import com.joandkim.greenery.dto.signup.SignupResponse;
import com.joandkim.greenery.mapper.MemberMapper;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberMapper memberMapper;

    public SignupResponse signup(Member signupMember) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        signupMember.setPassword(encoder.encode(signupMember.getPassword()));
        signupMember.setRole("ROLE_USER");
        memberMapper.save(signupMember);

        return SignupResponse.builder()
                .accessToken(jwtTokenProvider.createToken(signupMember.getUsername()))
                .nickname(signupMember.getNickname())
                .profileImageUrl(signupMember.getProfileImageUrl())
                .build();
    }

    public CheckedDuplicatedName checkDuplicatedName(String username, String nickname) {
        if (username != null) {
            return memberMapper.hasDuplicatedUsername(username);
        }
        if (nickname != null) {
            return memberMapper.hasDuplicatedNickname(nickname);
        }
        return null; // TODO exception 처리 필요
    }
}
