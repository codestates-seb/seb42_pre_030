package com.vivarepublica.vivastackoverflow.domain.answer.service;

import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.repository.AnswerRepository;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer) {
        /* Todo:
            - 작성자가 존재한지 확인필요
            - 답변한 질문글이 존재한지 확인필요
         */

        return answerRepository.save(answer);
    }

    public Answer findAnswer(Long answerId){
        return findVerifiedAnswer(answerId);
    }

    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page, size,
                Sort.by("answerId").descending()));  // Todo: 답변 목록 정렬을 좋아요 순으로 하기로 했으니 일단 보류, 現 descending(내림차순)
    }

    private Answer findVerifiedAnswer(Long answerId) { // 요청한 질문글이 있는지 예외 검사
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);

        return optionalAnswer.orElseThrow(() ->
                new RuntimeException("Answer not found"));
    }
}
