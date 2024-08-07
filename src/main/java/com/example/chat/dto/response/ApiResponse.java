package com.example.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiResponse {
    private final Integer resultCode;
    private final String resultMsg;
    private final Object result;

}
