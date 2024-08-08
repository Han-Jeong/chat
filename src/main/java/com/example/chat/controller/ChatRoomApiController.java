package com.example.chat.controller;

import com.example.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/room")
@RestController
public class ChatRoomApiController {
    private final RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<Long> createRoom(@RequestParam Long memberId,
                                           @RequestParam String name) {
        return ResponseEntity.ok(roomService.createRoom(memberId, name));
    }
}
