package com.example.chat.service;

import com.example.chat.dto.ChatDto;
import com.example.chat.dto.MessageDto;
import com.example.chat.entity.Message;
import com.example.chat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public String send(ChatDto chatDto) {
        Message message = Message.builder()
                .content(chatDto.getMessage())
                .senderNickname(chatDto.getSenderNickname())
                .build();
        Message save = messageRepository.save(message);
        return save.getId();
    }
}
