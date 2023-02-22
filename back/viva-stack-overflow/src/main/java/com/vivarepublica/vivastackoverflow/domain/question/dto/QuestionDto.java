package com.vivarepublica.vivastackoverflow.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.List;

public class QuestionDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class PostDto {

        private String title;

        private String content;

        private List<String> tag;

        //private Blob files;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class PatchDto {

        private Long questionId;

        private String title;

        private String content;

        //private Blob files;

        private List<String> tag;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ResponseDto {

        private Long questionId;

        private String title;

        private String content;

        //파일
        //private Blob files;

        //tag 이름만 보내면 되니까 List<String> 처리
        private List<String> tag;

        //like 갯수만 필요하므로 int 처리
        private int like;

    }

}
