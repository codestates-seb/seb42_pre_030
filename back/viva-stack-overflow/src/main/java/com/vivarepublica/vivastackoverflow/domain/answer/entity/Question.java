package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
