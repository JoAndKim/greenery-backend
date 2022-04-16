package com.joandkim.greenery.controller.member;

import com.joandkim.greenery.dto.member.LoginMember;
import com.joandkim.greenery.service.member.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    // 로그인
    @PostMapping("/direct")
    public String login(@RequestBody LoginMember member) {
        String token = loginService.login(member);
        return token;
    }
}
