package com.vivarepublica.vivastackoverflow.domain.question.entity;

import com.vivarepublica.vivastackoverflow.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Getter
@Setter
public class Question extends Auditable {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long questionId;

       @Column(length = 100, nullable = false)
       private String title;

       @Column(length = 9999, nullable = false)
       private String content;

       @Column(nullable = false)
       private int views;

       @Column
       private Blob files;

       //db join
       //@OneToMany(mappedBy = "question")
       //private List<String> tag = new ArrayList<>();

       //db join
       //@OneToMany(mappedBy = "question")
       //private int like;

}
