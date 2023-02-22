package com.vivarepublica.vivastackoverflow.domain.answer.repository;

import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
