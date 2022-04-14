package com.joandkim.greenery.controller.member;

import com.joandkim.greenery.service.SignupService;
import com.joandkim.greenery.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<Void> signup(@RequestBody Member signupMember) {
        signupService.signup(signupMember);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
