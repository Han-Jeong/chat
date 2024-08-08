package com.example.chat.controller;

import com.example.chat.dto.MessageDto;
import com.example.chat.dto.response.ApiResponse;
import com.example.chat.service.stomp.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    /**
     * 생산자(Proceduer)가 메시지를 전송합니다.
     *
     * @param messageDto
     * @return
     */
    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDto messageDto) {
        String result = "";

        producerService.sendMessage(messageDto);
        ApiResponse ar = ApiResponse.builder()
                .result(result)
                .resultCode(200)
                .resultMsg("success")
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }
}