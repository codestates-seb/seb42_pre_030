package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Answer /*extends Auditable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")  // Question Table 참조
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")  // Member Table 참조
    private Member member;

    @Column(nullable = false, length = 9999) // Content length = ? | columnDefinition = "TEXT" <- DataBase 타입 결정
    private String content;

    /* Auditable 처리
     * Todo: 작성일 - createdAt
     *
     * Todo: 수정일 - modifiedAt */

    // Todo: 첨부파일 Advanced
}
