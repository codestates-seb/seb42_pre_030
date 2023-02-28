package com.vivarepublica.vivastackoverflow.domain.answer.mapper;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T21:29:54+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPatchDtoToAnswer(AnswerDto.Patch answerPatchDto) {
        if ( answerPatchDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerPatchDto.getAnswerId() );
        answer.setContent( answerPatchDto.getContent() );

        return answer;
    }

    @Override
    public AnswerDto.Response answerToAnswerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDto.Response.AnswerMember answerMember = null;
        String createdAt = null;
        String modifiedAt = null;
        Long answerId = null;
        String content = null;

        answerMember = memberToAnswerMember( answer.getMember() );
        createdAt = answer.getPrettyCreatedAt();
        modifiedAt = answer.getPrettyModifiedAt();
        answerId = answer.getAnswerId();
        content = answer.getContent();

        AnswerDto.Response response = new AnswerDto.Response( answerId, content, createdAt, modifiedAt, answerMember );

        return response;
    }

    @Override
    public List<AnswerDto.Response> answerToAnswerResponseDtos(List<Answer> answers) {
        if ( answers == null ) {
            return null;
        }

        List<AnswerDto.Response> list = new ArrayList<AnswerDto.Response>( answers.size() );
        for ( Answer answer : answers ) {
            list.add( answerToAnswerResponseDto( answer ) );
        }

        return list;
    }

    protected AnswerDto.Response.AnswerMember memberToAnswerMember(Member member) {
        if ( member == null ) {
            return null;
        }

        Long memberId = null;
        String email = null;
        String nickname = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        nickname = member.getNickname();

        AnswerDto.Response.AnswerMember answerMember = new AnswerDto.Response.AnswerMember( memberId, email, nickname );

        return answerMember;
    }
}
