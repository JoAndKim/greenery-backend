package com.joandkim.greenery.controller.member;

import com.joandkim.greenery.dto.signup.CheckedDuplicatedName;
import com.joandkim.greenery.dto.signup.SignupResponse;
import com.joandkim.greenery.service.member.SignupService;
import com.joandkim.greenery.vo.Member;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @Operation(summary = "회원가입", description = "성공적으로 회원가입하면 JWT를 발급받는다")
    @PostMapping
    public ResponseEntity<SignupResponse> signup(@RequestBody Member signupMember) {
        SignupResponse signupResponse = signupService.signup(signupMember);
        return ResponseEntity.ok(signupResponse);
    }

    @GetMapping("validate")
    public ResponseEntity checkDuplicated(@RequestParam(required = false) String username,
                                          @RequestParam(required = false) String nickname) {
        CheckedDuplicatedName checkedDuplicatedName = signupService.checkDuplicatedName(username, nickname);
        return ResponseEntity.ok(checkedDuplicatedName);
    }
}
