package com.joandkim.greenery.controller.post.comment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(CommentController.class) Failed to load ApplicationContext
class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("사용자의 코멘트를 저장한다")
    public void saveComment() {

    }
}
