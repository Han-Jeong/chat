package com.example.chat.service;

import com.example.chat.dto.MessageDto;

public interface ProducerService {
    // 메시지를 큐로 전송 합니다.
    void sendMessage(MessageDto messageDto);
}
