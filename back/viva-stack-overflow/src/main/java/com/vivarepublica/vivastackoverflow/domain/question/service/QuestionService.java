package com.vivarepublica.vivastackoverflow.domain.question.service;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.question.repository.QuestionRepository;
import com.vivarepublica.vivastackoverflow.exception.BusinessLogicException;
import com.vivarepublica.vivastackoverflow.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    //질문 작성
    public Question create(Question question) {

        return questionRepository.save(question);
    }

    public Question patch(Question question) {

        //Id 기준 조회
        Question originalQuestion = verifyQuestionById(question.getQuestionId());

        //null값을 포함하고 있는 Question객체(수정 요청 사항)을 조회해 온 question(original)에 반영 => 수정 처리
        Optional.of(question.getTitle()).ifPresent(title -> originalQuestion.setTitle(title));
        Optional.of(question.getContent()).ifPresent(content -> originalQuestion.setContent(content));
        //Optional.ofNullable(question.getTag()).ifPresent(tag -> originalQuestion.setTag(tag));

        //DB에 다시 저장
        Question patchQuestion = questionRepository.save(originalQuestion);

        return patchQuestion;

    }

    //단일 조회
    public Question getOne(Long questionId) {
        return verifyQuestionById(questionId);
    }

    //전체 조회
    public Page<Question> getAll(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
    }

    //단일 삭제
    public void deleteOne(Long questionId) {
        verifyQuestionById(questionId);
        questionRepository.deleteById(questionId);
    }

    //전체 삭제
    public void deleteAll(){
        questionRepository.deleteAll();
    }

    //Id 기준 조회
    private Question verifyQuestionById(Long questionId) {
        Optional<Question> OptionalQuestion = questionRepository.findById(questionId);
        if (OptionalQuestion.isEmpty()) {
            throw new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND);
        }
        return OptionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
    }

}
