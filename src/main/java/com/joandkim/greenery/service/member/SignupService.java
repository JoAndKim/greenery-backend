package com.joandkim.greenery.service.member;

import com.joandkim.greenery.dto.NewAccessMemberResponse;
import com.joandkim.greenery.util.JwtTokenProvider;
import com.joandkim.greenery.dto.signup.CheckedDuplicatedName;
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

    public NewAccessMemberResponse signup(Member signupMember) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        signupMember.setPassword(encoder.encode(signupMember.getPassword()));

        signupMember.setRole("ROLE_USER");

        String refreshToken = jwtTokenProvider.createRefreshToken(signupMember.getUsername());
        signupMember.setRefreshToken(refreshToken);

        memberMapper.save(signupMember);

        return NewAccessMemberResponse.builder()
                .accessToken(jwtTokenProvider.createToken(signupMember.getUsername()))
                .refreshToken(refreshToken)
                .refreshTokenExpiryDate(jwtTokenProvider.getRefreshTokenExpiryTime())
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
