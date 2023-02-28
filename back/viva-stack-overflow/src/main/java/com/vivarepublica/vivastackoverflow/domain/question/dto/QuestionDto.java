package com.vivarepublica.vivastackoverflow.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class QuestionDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {

        @NotBlank(message = "필수 기입 항목입니다.")
        private String title;

        @NotBlank(message = "필수 기입 항목입니다.")
        private String content;

//        private Set<Tag> tag;
//
//        private Long tagId;
//
//        private HashTag tagName;
//
//        private Set<Question> questions;


    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {

        private Long questionId;

        @NotBlank(message = "필수 기입 항목입니다.")
        private String title;

        @NotBlank(message = "필수 기입 항목입니다.")
        private String content;

//        private Set<Tag> tag;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {

        private Long questionId;

        private String title;

        private String content;

        //파일
        //private Blob files;

        //tag 이름만 보내면 되니까 List<String> 처리
//        private Set<Tag> tag;

        //like 갯수만 필요하므로 int 처리
        private int like;

    }

}
