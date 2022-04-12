package com.joandkim.greenery.mapper;

import com.joandkim.greenery.vo.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper{

    List<Post> findAll();
}
