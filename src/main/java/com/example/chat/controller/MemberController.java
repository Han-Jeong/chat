package com.example.chat.controller;

import com.example.chat.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/members")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    @PostMapping
    public ResponseEntity<Long> createMember(@RequestParam String username) {
        return ResponseEntity.ok(memberService.createMember(username));
    }

}
