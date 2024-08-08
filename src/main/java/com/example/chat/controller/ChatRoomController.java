package com.example.chat.controller;

import com.example.chat.dto.RoomDto;
import com.example.chat.entity.Room;
import com.example.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public String getRooms(Model model) {
        List<Room> all = roomService.findAll();
        List<RoomDto> collect = all.stream()
                .map(room -> convert(room))
                .collect(Collectors.toList());
        model.addAttribute("rooms", collect);
        return "chat/rooms";
    }

    @GetMapping("/room")
    public String getRoom(Long chatRoomId, String nickname, Model model) {
        //TODO 입장 validate
        model.addAttribute("chatRoomId", chatRoomId);
        model.addAttribute("nickname", nickname);
        return "chat/room";
    }

    private RoomDto convert(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .build();
    }
}
