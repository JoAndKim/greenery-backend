package com.joandkim.greenery.service.member;

import com.joandkim.greenery.config.jwt.JwtTokenProvider;
import com.joandkim.greenery.dto.member.LoginMember;
import com.joandkim.greenery.mapper.MemberMapper;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public Member loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberMapper.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.: " + username));
    }


}
