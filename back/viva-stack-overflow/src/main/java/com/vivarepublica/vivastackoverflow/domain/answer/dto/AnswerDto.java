package com.vivarepublica.vivastackoverflow.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AnswerDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        private Long questionId;
        private Long memberId;
        private String content;

        // TODO: 첨부파일
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long answerId;
        private String content;
    }
}
