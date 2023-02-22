package com.vivarepublica.vivastackoverflow.domain.question.service;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question createQuestion(Question question) {

        return questionRepository.save(question);
    }

    //단일 조회
    public Question getOne(Long questionId) {
        return verifyQuestionById(questionId);
    }

    //전체 조회
    public List<Question> getAll() {
        return questionRepository.findAll();
    }


    private Question verifyQuestionById(Long questionId) {
        Optional<Question> getQuestion = questionRepository.findById(questionId);
        if (getQuestion.isEmpty()) {
            throw new RuntimeException("존재하지 않는 질문입니다.");
        }
        return getQuestion.get();
    }
}
