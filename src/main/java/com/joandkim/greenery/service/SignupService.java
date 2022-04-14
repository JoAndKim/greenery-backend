package com.joandkim.greenery.service;

import com.joandkim.greenery.mapper.MemberMapper;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final MemberMapper memberMapper;

    public void signup(Member signupMember) {
        memberMapper.save(signupMember);
    }
}
