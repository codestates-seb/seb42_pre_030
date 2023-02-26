package com.vivarepublica.vivastackoverflow.domain.question.repository;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
//    Page<Question> findAllByQuestionTitlle(String title, Pageable pageable);
}
