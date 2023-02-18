package com.vivarepublica.vivastackoverflow.domain.question.service;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question createQuestion(Question question) {

        return questionRepository.save(question);
    }
}
