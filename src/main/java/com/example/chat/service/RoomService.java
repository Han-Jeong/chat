package com.example.chat.service;

import com.example.chat.entity.Member;
import com.example.chat.entity.Room;
import com.example.chat.entity.RoomJoin;
import com.example.chat.repository.MemberRepository;
import com.example.chat.repository.RoomJoinRepository;
import com.example.chat.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomJoinRepository roomJoinRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long createRoom(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found"));
        Room room = Room.builder().build();
        roomRepository.save(room);
        roomJoinRepository.save(RoomJoin.builder()
                .room(room)
                .member(member)
                .build());
        return room.getId();
    }

    @Transactional(readOnly = true)
    public Room findById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Transactional
    public void joinRoom(Long memberId, Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("not found"));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found"));

        RoomJoin roomJoin = RoomJoin.builder()
                .room(room)
                .member(member)
                .build();

        roomJoinRepository.save(roomJoin);
    }
}
