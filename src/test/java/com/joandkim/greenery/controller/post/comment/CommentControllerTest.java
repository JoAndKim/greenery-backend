package com.joandkim.greenery.controller.post.comment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     *
     * 컨트롤러 자체에는 단위 테스트가 필요할 만한 비지니스 로직이 존재하지 않는다.
     * 요청 경로와 처리 내용의 매핑이나 요청 데이터의 취득, 입력값 검사와 같은 부분은 스프링 MVC의 프레임워크 기능을 사용해야만
     * 그 처리결과가 제대로 됐는지 검증 가능하다. 따라서 컨트롤러의 테스트는 단위테스트라기 보단 통합테스트의 관점으로 봐야한다.
     *
     */
    @Test
    @DisplayName("사용자의 코멘트를 저장하는 컨트롤러를 테스트")
    public void saveComment() throws Exception {
    }
}
