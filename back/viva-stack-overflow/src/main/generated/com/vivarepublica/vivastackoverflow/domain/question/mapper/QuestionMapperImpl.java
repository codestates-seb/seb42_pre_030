package com.vivarepublica.vivastackoverflow.domain.question.mapper;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-28T05:22:15+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionDto.Post questionPost) {
        if ( questionPost == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( questionPost.getTitle() );
        question.setContent( questionPost.getContent() );

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionDto.Patch questionPatch) {
        if ( questionPatch == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionPatch.getQuestionId() );
        question.setTitle( questionPatch.getTitle() );
        question.setContent( questionPatch.getContent() );

        return question;
    }

    @Override
    public Question questionResponseDtoToQuestion(QuestionDto.Response questionResponse) {
        if ( questionResponse == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionResponse.getQuestionId() );
        question.setTitle( questionResponse.getTitle() );
        question.setContent( questionResponse.getContent() );

        return question;
    }

    @Override
    public QuestionDto.Response questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Long questionId = null;
        String title = null;
        String content = null;

        questionId = question.getQuestionId();
        title = question.getTitle();
        content = question.getContent();

        int like = 0;

        QuestionDto.Response response = new QuestionDto.Response( questionId, title, content, like );

        return response;
    }

    @Override
    public List<QuestionDto.Response> questionToQuestionResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionDto.Response> list = new ArrayList<QuestionDto.Response>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionResponseDto( question ) );
        }

        return list;
    }
}
