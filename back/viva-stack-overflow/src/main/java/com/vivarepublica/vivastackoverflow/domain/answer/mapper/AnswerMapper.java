package com.vivarepublica.vivastackoverflow.domain.answer.mapper;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    default Answer answerPostDtoToAnswer(AnswerDto.Post answerPostDto) {
        Answer answer = new Answer();
        Member member = new Member();
        Question question = new Question();

        member.setMemberId(answerPostDto.getMemberId());
//        question.setQuestionId(answerPostDto.getQuestionId()); // Todo: Question 구현이 완료되면 적용
        answer.setContent(answerPostDto.getContent());

        answer.setMember(member);
//        answer.setQuestion(question); // Todo: Question 구현이 완료되면 적용

        return answer;
    }

    @Mapping(source = "member.memberId", target = "memberId")
    @Mapping(source = "member.email", target = "email")
    @Mapping(source = "member.nickname", target = "nickname")
    AnswerDto.Response answerToAnswerResponseDto(Answer answer);

    List<AnswerDto.Response> answerToAnswerResponseDtos(List<Answer> answers);
}
