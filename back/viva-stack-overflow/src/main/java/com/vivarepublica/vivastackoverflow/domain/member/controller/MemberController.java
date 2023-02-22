package com.vivarepublica.vivastackoverflow.domain.member.controller;

import com.vivarepublica.vivastackoverflow.domain.member.dto.MemberDto;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.member.mapper.MemberMapper;
import com.vivarepublica.vivastackoverflow.domain.member.service.MemberService;
import com.vivarepublica.vivastackoverflow.util.UriCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/members";
    private final MemberService memberService;
    private final MemberMapper mapper;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {
        Member member = mapper.memberPostDtoToMember(requestBody);

        Member createdMember = memberService.createMember(member);

        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getMemberId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {
        Member foundMember = memberService.findMember(memberId);

        MemberDto.Response responseBody = mapper.memberToMemberResponseDto(foundMember);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive Long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
