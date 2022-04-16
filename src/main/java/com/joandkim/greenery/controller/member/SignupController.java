package com.joandkim.greenery.controller.member;

import com.joandkim.greenery.service.member.SignupService;
import com.joandkim.greenery.vo.Member;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signup")
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @Operation(summary = "회원가입", description = "성공적으로 회원가입하면 JWT를 발급받는다")
    @PostMapping
    public ResponseEntity<String> signup(@RequestBody Member signupMember) {
        String token = signupService.signup(signupMember);
        return ResponseEntity.ok(token);
    }
}
