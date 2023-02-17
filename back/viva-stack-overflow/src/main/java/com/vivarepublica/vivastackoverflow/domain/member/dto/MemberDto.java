package com.vivarepublica.vivastackoverflow.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        private String email;
        private String password;
        private String nickname;
    }
    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long memberId;
        private String email;
        private String nickname;
    }
}
