package com.vivarepublica.vivastackoverflow.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class AnswerDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        @Positive
        private Long questionId;
        @Positive
        private Long memberId;
        @NotBlank(message = "답변은 공백이 아니어야 합니다")
        private String content;

        // TODO: 첨부파일
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long answerId;
        @NotBlank(message = "답변은 공백이 아니어야 합니다")
        private String content;
        private Long memberId;
        private String email;
        private String nickname;
    }
}
