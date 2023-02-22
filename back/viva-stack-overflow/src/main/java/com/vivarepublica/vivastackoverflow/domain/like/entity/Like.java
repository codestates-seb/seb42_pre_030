package com.vivarepublica.vivastackoverflow.domain.like.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    // Member pull한 다음에 만들기
    //private Member member;

    //join
    //private Question question;

}
