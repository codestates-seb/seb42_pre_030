package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class AnswerLike {
    private Long answerLikeId;
    private Long memberId;
    private Long answerId;
}
