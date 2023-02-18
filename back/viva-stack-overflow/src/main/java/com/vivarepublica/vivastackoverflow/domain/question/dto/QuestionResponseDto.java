package com.vivarepublica.vivastackoverflow.domain.question.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResponseDto {

    private Long questionId;

    private String title;

    private String content;

    private String tag;

}
