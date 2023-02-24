package com.vivarepublica.vivastackoverflow.domain.like.dto;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto {

    private Question question;

    //private Member member;
}
