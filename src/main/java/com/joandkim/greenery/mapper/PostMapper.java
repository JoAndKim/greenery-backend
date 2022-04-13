package com.joandkim.greenery.mapper;

import com.joandkim.greenery.dto.post.BriefPost;
import com.joandkim.greenery.dto.post.main.MainPosts;
import com.joandkim.greenery.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper{

    List<Post> findAll();

    List<BriefPost> getBriefPost();

    List<BriefPost> getBriefPost(Boolean forMain);
}
