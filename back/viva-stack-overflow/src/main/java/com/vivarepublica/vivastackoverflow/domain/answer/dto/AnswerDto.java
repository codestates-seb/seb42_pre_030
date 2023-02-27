package com.vivarepublica.vivastackoverflow.domain.answer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

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
    public static class Patch {
        private Long answerId;
        @NotBlank(message = "답변은 공백이 아니어야 합니다")
        private String content;

        public Patch addAnswerId(Long answerId) {
            Assert.notNull(answerId, "answer id must not be null."); // NULL 검증, 값이 NULL이면 IllegalArgumentException
            this.answerId = answerId;
            return this;
        }
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long answerId;
        private String content;
        private String createdAt;
        private String modifiedAt;
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
