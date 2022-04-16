package com.joandkim.greenery.mapper;

import com.joandkim.greenery.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    void save(Member signupMember);

    Optional<Member> findByUsername(String username);
}
