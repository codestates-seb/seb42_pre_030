package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {
    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 9999, nullable = false)
    private String content;

    @Column
    private int views;

    @Column
    private String tag;

    // Todo: Question cascade를 위해서 양방향 매핑 적용. -- !.Question Domain 구현이 완료되면 지울 예정
//    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // Todo: Question 구현이 완료되면 적용
//    List<Answer> Answers = new ArrayList<>();
}
