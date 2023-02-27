package com.vivarepublica.vivastackoverflow.domain.question.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion.question;

@RequiredArgsConstructor
@Repository
public class QuestionRepositoryImpl implements QuestionCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public void addLikeCount(Question selectedQuestion) {
        queryFactory.update(question)
                .set(question.likeCount, question.likeCount.add(1))
                .where(question.eq(selectedQuestion))
                .execute();
    }
}
