package com.vivarepublica.vivastackoverflow.domain.answer.service;

import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.repository.AnswerRepository;
import com.vivarepublica.vivastackoverflow.domain.member.service.MemberService;
import com.vivarepublica.vivastackoverflow.domain.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final MemberService memberService;

    public Answer createAnswer(Answer answer) {
        verifyAnswer(answer);

        return answerRepository.save(answer);
    }

    @Transactional(readOnly = true)
    public Answer findAnswer(Long answerId){
        return findVerifiedAnswer(answerId);
    }

    @Transactional(readOnly = true)
    public Page<Answer> findAnswers(Long questionId, int page, int size) {
        List<Answer> answers = answerRepository.findByQuestion_QuestionId(questionId); // 특정 질문ID의 답변 데이터 가져오기
        for (Answer answer: answers) {  // LocalDateTime 데이터를 깔끔하게 Response하기 위해 format 적용
            answer.setPrettyCreatedAt();
        }

        return new PageImpl<>(answers, PageRequest.of(page, size, Sort.by("answerId")),answers.size()); // Todo: 답변 목록 정렬을 좋아요 순으로 하기로 했으니 일단 보류, 現 오름차순
    }

    private Answer findVerifiedAnswer(Long answerId) { // 요청한 질문글이 있는지 검증
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);

        return optionalAnswer.orElseThrow(() ->
                new RuntimeException("Answer not found"));
    }

    private void verifyAnswer(Answer answer) { // 작성자, 질문글 검증
        questionService.getOne(answer.getQuestion().getQuestionId());
        memberService.findMember(answer.getMember().getMemberId());
    }
}
