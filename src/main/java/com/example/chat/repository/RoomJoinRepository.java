package com.example.chat.repository;

import com.example.chat.entity.RoomJoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomJoinRepository extends JpaRepository<RoomJoin, Long> {
}
