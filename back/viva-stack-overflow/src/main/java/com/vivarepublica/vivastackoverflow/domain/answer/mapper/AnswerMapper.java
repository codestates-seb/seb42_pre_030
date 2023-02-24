package com.vivarepublica.vivastackoverflow.domain.answer.mapper;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
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
        question.setQuestionId(answerPostDto.getQuestionId());
        answer.setContent(answerPostDto.getContent());

        answer.setMember(member);
        answer.setQuestion(question);

        return answer;
    }

    @Mapping(source = "prettyCreatedAt", target = "createdAt")
    @Mapping(source = "member.memberId", target = "answerMember.memberId")
    @Mapping(source = "member.email", target = "answerMember.email")
    @Mapping(source = "member.nickname", target = "answerMember.nickname")
    AnswerDto.Response answerToAnswerResponseDto(Answer answer);

    List<AnswerDto.Response> answerToAnswerResponseDtos(List<Answer> answers);
}
