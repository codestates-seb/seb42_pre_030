package com.vivarepublica.vivastackoverflow.domain.answer.mapper;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    default Answer answerPostDtoToAnswer(AnswerDto.Post answerPostDto) {
        Answer answer = new Answer();
        Member member = new Member();
        Question question = new Question();

        member.setMemberId(answerPostDto.getMemberId());
        question.setQuestionId(answerPostDto.getQuestionId());
        answer.setContent(answerPostDto.getContent());

        return answer;
    }

    AnswerDto.Response answerToAnswerResponseDto(Answer answer);
    List<AnswerDto.Response> answerToAnswerResponseDtos(List<Answer> answers);
}
