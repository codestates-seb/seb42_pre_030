package com.vivarepublica.vivastackoverflow.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AnswerDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        public Post(){} // 기본 생성자를 안넣으면 매핑이 안됨 왜 그럴까??
        private String content;

        // TODO: 첨부파일
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long answerId;
        private String content;
    }
}
