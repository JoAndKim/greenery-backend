package com.joandkim.greenery.mapper;

import com.joandkim.greenery.dto.post.BriefPost;
import com.joandkim.greenery.dto.post.NewPost;
import com.joandkim.greenery.dto.post.detail.PostDetail;
import com.joandkim.greenery.dto.post.main.MainPosts;
import com.joandkim.greenery.vo.Member;
import com.joandkim.greenery.vo.Post;
import com.joandkim.greenery.vo.PostContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper{

    List<Post> findAll();

    List<BriefPost> getBriefPost();

    List<BriefPost> getBriefPost(Boolean forMain);

    PostDetail getPostDetail(Long postId);

    void save(NewPost newPost);

    void savePostContents(@Param("postContents") List<PostContent> postContents,
                          @Param("postId") Long postId);

    Boolean findLikeByPostIdAndMemberId(@Param("postId") Long postId,
                                        @Param("memberId") Long memberId);
    void saveLike(@Param("postId") Long postId,
                  @Param("memberId") Long memberId);


    void deleteLike(@Param("postId") Long postId,
                    @Param("memberId") Long memberId);
}
