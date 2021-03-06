package com.joandkim.greenery.mapper;

import com.joandkim.greenery.dto.signup.CheckedDuplicatedName;
import com.joandkim.greenery.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    void save(Member signupMember);

    Optional<Member> findByUsername(String username);

    CheckedDuplicatedName hasDuplicatedUsername(String username);

    CheckedDuplicatedName hasDuplicatedNickname(String username);

    String findRefreshTokenByUsername(String username);

    void updateRefreshToken(@Param("username") String username,
                            @Param("refreshToken") String refreshToken);
}
