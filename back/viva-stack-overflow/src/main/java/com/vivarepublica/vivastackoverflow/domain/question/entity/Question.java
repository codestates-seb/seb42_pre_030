package com.vivarepublica.vivastackoverflow.domain.question.entity;

import com.vivarepublica.vivastackoverflow.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Question extends Auditable {

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
