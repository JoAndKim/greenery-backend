package com.joandkim.greenery.service;

import com.joandkim.greenery.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final MemberMapper memberMapper;

    public boolean checkIfRefreshTokenIsValid(String refreshToken, String username) {
        String storedRefreshToken = memberMapper.findRefreshTokenByUsername(username);
        return storedRefreshToken.equals(refreshToken);
    }
}
