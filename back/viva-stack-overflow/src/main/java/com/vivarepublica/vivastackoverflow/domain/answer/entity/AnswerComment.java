package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class AnswerComment {
    private Long commentId;
    private Long answerId;
    private Long memberId;
    private String content;

    // Todo: 작성일 - createdAt

    // Todo: 수정일 - modifiedAt
}
