package com.hihisososo.realworld.controller;

import com.hihisososo.realworld.dto.MemberLoginDTO;
import com.hihisososo.realworld.dto.MemberRegisterDTO;
import com.hihisososo.realworld.dto.MemberUpdateDTO;
import com.hihisososo.realworld.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {
    public static final String AUTHORIZATION = "Authorization";
    private final MemberService memberService;

    @PostMapping("/users/login")
    public ResponseEntity login(@RequestBody @Valid MemberLoginDTO memberLoginDTO) {
        return ResponseEntity.ok(memberService.login(memberLoginDTO));
    }

    @PostMapping("/users")
    public ResponseEntity register(@RequestBody @Valid MemberRegisterDTO memberRegisterDTO) {
        return ResponseEntity.ok(memberService.register(memberRegisterDTO));
    }

    @GetMapping("/user")
    public ResponseEntity get(HttpServletRequest request) {
        return ResponseEntity.ok(memberService.get(request.getHeader(AUTHORIZATION)));
    }

    @PutMapping("/user")
    public ResponseEntity put(HttpServletRequest request,@RequestBody @Valid MemberUpdateDTO memberUpdateDTO) {
        return ResponseEntity.ok(memberService.update(request.getHeader(AUTHORIZATION), memberUpdateDTO));
    }
}