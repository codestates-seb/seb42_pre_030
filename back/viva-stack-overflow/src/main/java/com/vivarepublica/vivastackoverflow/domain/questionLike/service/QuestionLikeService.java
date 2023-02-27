package com.vivarepublica.vivastackoverflow.domain.questionLike.service;

import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.member.repository.MemberRepository;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.question.repository.QuestionRepository;
import com.vivarepublica.vivastackoverflow.domain.questionLike.dto.QuestionLikeDto;
import com.vivarepublica.vivastackoverflow.domain.questionLike.entity.QuestionLike;
import com.vivarepublica.vivastackoverflow.domain.questionLike.repository.QuestionLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionLikeService {

    private final QuestionLikeRepository questionLikeRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;

    public QuestionLikeDto post(QuestionLikeDto questionLikeDto) throws Exception {

        Member member = memberRepository.findById(questionLikeDto.getMemberId())
                .orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        Question question = questionRepository.findById(questionLikeDto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("질문을 찾을 수 없습니다."));

        //좋아요 이미 존재할 경우 에러 리턴
        if (questionLikeRepository.findByMemberAndQuestion(member, question).isPresent()) {
            // error
            throw new RuntimeException("이미 처리된 좋아요입니다.");
        }

        QuestionLike questionLike = QuestionLike.builder()
                                                .question(question)
                                                .member(member)
                                                .build();

        questionLikeRepository.save(questionLike);
        questionRepository.addLikeCount(question);
        return questionLikeDto;
    }

}
