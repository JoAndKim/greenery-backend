package com.joandkim.greenery.controller.member;

import com.joandkim.greenery.dto.login.LoginMemberRequest;
import com.joandkim.greenery.dto.login.LoginMemberResponse;
import com.joandkim.greenery.service.member.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    @Operation(summary = "로그인", description = "성공적으로 로그인하면 JWT를 발급받는다")
    @PostMapping("/direct")
    public ResponseEntity<LoginMemberResponse> login(@RequestBody LoginMemberRequest member) {
        LoginMemberResponse memberResponse = loginService.login(member);
        return ResponseEntity.ok(memberResponse);
    }
}
