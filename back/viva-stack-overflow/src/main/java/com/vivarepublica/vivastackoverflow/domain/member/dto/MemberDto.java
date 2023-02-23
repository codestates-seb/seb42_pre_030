package com.vivarepublica.vivastackoverflow.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        @NotBlank(message = "이메일은 필수 입력 사항입니다.")
        @Email
        private String email;
        @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
        message = "비밀번호는 최소 알파벳 문자 하나와 숫자 하나를 포함하여 8자 이상이어야 합니다.")
        private String password;
        @NotBlank(message = "별명은 필수 입력 사항입니다.")
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
