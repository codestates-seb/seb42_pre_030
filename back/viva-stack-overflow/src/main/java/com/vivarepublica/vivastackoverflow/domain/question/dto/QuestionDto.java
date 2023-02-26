package com.vivarepublica.vivastackoverflow.domain.question.dto;

import com.vivarepublica.vivastackoverflow.domain.tag.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class QuestionDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class PostDto {

        @NotBlank(message = "필수 기입 항목입니다.")
        private String title;

        @NotBlank(message = "필수 기입 항목입니다.")
        private String content;

        private List<Tag> tag;


    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class PatchDto {

        private Long questionId;

        @NotBlank(message = "필수 기입 항목입니다.")
        private String title;

        @NotBlank(message = "필수 기입 항목입니다.")
        private String content;

        private List<Tag> tag;

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
        private List<Tag> tag;

        //like 갯수만 필요하므로 int 처리
        private int like;

    }

}
