package com.example.chat.service;

import com.example.chat.domain.channel.Channel;
import com.example.chat.domain.channel.ChannelJoin;
import com.example.chat.domain.member.Member;
import com.example.chat.repository.ChannelJoinRepository;
import com.example.chat.repository.ChannelRepository;
import com.example.chat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChannelService {

    private final ChannelRepository channelRepository;
    private final MemberRepository memberRepository;
    private final ChannelJoinRepository channelJoinRepository;

    @Transactional
    public Long createChannel(Long memberId) {
        Channel channel = Channel.builder()
                .name("channel")
                .build();

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found member"));

        ChannelJoin channelJoin = ChannelJoin.builder()
                .member(member)
                .channel(channel)
                .build();

        Channel save = channelRepository.save(channel);
        channelJoinRepository.save(channelJoin);
        return save.getId();
    }

    @Transactional(readOnly = true)
    public Channel findChannel(Long channelId) {
        return channelRepository.findById(channelId)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Transactional
    public void joinChannel(Long memberId, Long channelId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found member"));
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new RuntimeException("not found"));

        ChannelJoin channelJoin = ChannelJoin.builder()
                .member(member)
                .channel(channel)
                .build();

        channelJoinRepository.save(channelJoin);
    }
}
