package com.vivarepublica.vivastackoverflow.domain.question.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(length = 10, nullable = false)
    private String tagName;

    //private Question question;
}
