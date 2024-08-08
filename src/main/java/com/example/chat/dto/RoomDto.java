package com.example.chat.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
    private Long id;
    private String name;
}
