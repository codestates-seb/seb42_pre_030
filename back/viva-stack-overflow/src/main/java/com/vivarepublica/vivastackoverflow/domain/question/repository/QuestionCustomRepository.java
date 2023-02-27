package com.vivarepublica.vivastackoverflow.domain.question.repository;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;

public interface QuestionCustomRepository {

    void addLikeCount(Question question);
}
