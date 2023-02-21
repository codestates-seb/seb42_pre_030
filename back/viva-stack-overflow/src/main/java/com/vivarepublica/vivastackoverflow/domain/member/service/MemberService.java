package com.vivarepublica.vivastackoverflow.domain.member.service;

import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        // 이미 존재하는 회원인지 확인
        verifyExistsMember(member.getEmail());

        return memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return findVerifiedMember(memberId);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    private void verifyExistsMember(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if (optionalMember.isPresent()) {
            throw new RuntimeException("Member already exists");
        }
    }

    private Member findVerifiedMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        return optionalMember.orElseThrow(() ->
                new RuntimeException("Member not found"));
    }
}
