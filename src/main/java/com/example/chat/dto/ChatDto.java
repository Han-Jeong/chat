package com.example.chat.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatDto {
    private Long id;
    private Long chatRoomId;
    private Long memberId;
    private String message;
    private String region;
    private String senderNickname;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime regDate;
}
