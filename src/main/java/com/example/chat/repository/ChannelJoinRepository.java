package com.example.chat.repository;

import com.example.chat.domain.channel.ChannelJoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelJoinRepository extends JpaRepository<ChannelJoin, Long> {

}
