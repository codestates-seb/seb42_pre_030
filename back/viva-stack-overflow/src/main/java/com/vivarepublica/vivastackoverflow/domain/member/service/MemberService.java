package com.vivarepublica.vivastackoverflow.domain.member.service;

import com.vivarepublica.vivastackoverflow.auth.util.CustomAuthorityUtils;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public Member createMember(Member member) {
        // 이미 존재하는 회원인지 확인
        verifyExistsMember(member.getEmail());

        // 패스워드 암호화
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // 권한 부여
        List<String> roles = authorityUtils.createRoles();
        member.setRoles(roles);

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        Member foundMember = findVerifiedMember(member.getMemberId());

        foundMember.setNickname(member.getNickname());

        return foundMember;
    }

    @Transactional(readOnly = true)
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

    public void verifyAskedMember(long memberId1, long memberId2) {
        if (memberId1 != memberId2) {
            throw new RuntimeException("Asked member only");
        }
    }

    private Member findVerifiedMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        return optionalMember.orElseThrow(() ->
                new RuntimeException("Member not found"));
    }
}
