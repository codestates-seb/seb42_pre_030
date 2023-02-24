package com.vivarepublica.vivastackoverflow.domain.answer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

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
        private String content;
        private String createdAt;
        private AnswerMember answerMember;

        @AllArgsConstructor
        @Getter
        public static class AnswerMember {
            private Long memberId;
            private String email;
            private String nickname;
        }

    }
}
