package com.example.chat.controller;

import com.example.chat.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "api/member")
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Long> createMember(@RequestParam String nickname) {
        return ResponseEntity.ok(memberService.createMember(nickname));
    }

}
