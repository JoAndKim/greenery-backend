package com.joandkim.greenery.mapper;

import com.joandkim.greenery.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void save(Member signupMember);
}
