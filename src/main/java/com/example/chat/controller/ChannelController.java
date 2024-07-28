package com.example.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat")
@RequiredArgsConstructor
@Controller
public class ChannelController {
    @GetMapping("/rooms")
    public String getChannels() {
        return "chat/rooms";
    }

    @GetMapping("/room")
    public String getRoom(Long chatRoomId, String nickname, Model model) {
        model.addAttribute("chatRoomId", chatRoomId);
        model.addAttribute("nickname", nickname);
        return "chat/room";
    }
}
