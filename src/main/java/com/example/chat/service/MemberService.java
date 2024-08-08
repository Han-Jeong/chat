package com.example.chat.service;

import com.example.chat.entity.Member;
import com.example.chat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long createMember(String nickname) {
        Member member = Member.builder()
                .nickname(nickname)
                .build();
        Member save = memberRepository.save(member);
        return save.getId();
    }

    @Transactional(readOnly = true)
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
