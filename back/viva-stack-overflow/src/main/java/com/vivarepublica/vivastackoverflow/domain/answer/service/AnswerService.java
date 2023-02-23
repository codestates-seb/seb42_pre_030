package com.vivarepublica.vivastackoverflow.domain.answer.service;

import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer findAnswer(Long answerId){
        return findVerifiedAnswer(answerId);
    }

    /*Todo: 질문 글에 있는 답변들을 불러오기 위한 과정
    *  1. 요청받은 questionId로 특정 질문글에 있는 답변들을 추려내서 가져와야 한다.
    *  2. List<T> findAllById(Iterable<ID> ids) 로 답변들을 가져온다.
    *  3. 가져온 List를 PageImpl를 통해 PageNation처리
    *  4. Return
    * */
    public Page<Answer> findAnswers(Long questionId, int page, int size) {
        List<Answer> answers = answerRepository.findAllById(List.of(questionId)); // 특정 질문ID의 답변 데이터 가져오기
//         return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId")));

        return new PageImpl<>(answers, PageRequest.of(page, size, Sort.by("answerId")),answers.size());// Todo: 답변 목록 정렬을 좋아요 순으로 하기로 했으니 일단 보류, 現 오름차순
    }

    private Answer findVerifiedAnswer(Long answerId) { // 요청한 질문글이 있는지 예외 검사
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);

        return optionalAnswer.orElseThrow(() ->
                new RuntimeException("Answer not found"));
    }
}
