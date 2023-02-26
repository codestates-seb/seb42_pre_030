package com.vivarepublica.vivastackoverflow.domain.questionLike.entity;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class QuestionLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    // Member pull한 다음에 만들기
    //private Member member;

    //question join
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public void addQuestion(Question question) {
        this.question = question;
    }

}
