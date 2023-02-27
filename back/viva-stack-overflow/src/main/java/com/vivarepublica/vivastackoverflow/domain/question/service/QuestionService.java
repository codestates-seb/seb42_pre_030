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

    //질문 작성
    public Question createQuestion(Question question) {

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
    public List<Question> getAll() {
        return questionRepository.findAll();
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
            throw new RuntimeException("존재하지 않는 질문입니다.");
        }
        return OptionalQuestion.orElseThrow(() -> new RuntimeException("존재하지 않는 질문입니다."));
    }

}
