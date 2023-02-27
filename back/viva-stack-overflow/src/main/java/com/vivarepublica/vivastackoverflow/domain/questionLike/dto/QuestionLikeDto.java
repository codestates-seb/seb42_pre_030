package com.vivarepublica.vivastackoverflow.domain.questionLike.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionLikeDto {

    private Long memberId;
    private Long questionId;

}
