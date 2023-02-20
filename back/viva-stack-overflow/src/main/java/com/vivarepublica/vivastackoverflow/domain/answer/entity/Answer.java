package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Answer /*extends Auditable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long answerId;

//    @ManyToOne
//    @JoinColumn(name = "QUESTION_ID")  // Question Table 참조
    // TODO: private Type questionId;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")  // Member Table 참조
    // TODO: private Type memberId;

    @Column(nullable = false) // Content length = ? | columnDefinition = "TEXT" <- DataBase 타입 설정
    private String content;

    /* Auditable 처리
     * Todo: 작성일 - createdAt
     *
     * Todo: 수정일 - modifiedAt */

    // Todo: 첨부파일 Advanced
}
