package com.vivarepublica.vivastackoverflow.domain.member.controller;

import com.vivarepublica.vivastackoverflow.domain.member.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberDto.Post requestBody) {
        return ResponseEntity.created(URI.create("/members/1")).build();
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") Long memberId) {
        MemberDto.Response response =
                new MemberDto.Response(memberId, "frank@gmail.com", "francis");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") Long memberId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
