package com.vivarepublica.vivastackoverflow.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AnswerDto {
    @Getter
    public static class Post {
        private String content;

        // TODO: 첨부파일
    }
    @AllArgsConstructor
    @Getter
    public static class Response {
        private String content;
    }
}
