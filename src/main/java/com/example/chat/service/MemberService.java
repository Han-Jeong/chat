package com.example.chat.service;

import com.example.chat.domain.member.Member;
import com.example.chat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long createMember(String username) {
        Member member = Member.builder()
                .username(username)
                .build();
        Member save = memberRepository.save(member);
        return save.getId();
    }
}
