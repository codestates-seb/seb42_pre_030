package com.vivarepublica.vivastackoverflow.domain.question.mapper;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    //Post -> Question
    Question questionPostDtoToQuestion(QuestionDto.Post questionPost);

    //Patch -> Question
    Question questionPatchDtoToQuestion(QuestionDto.Patch questionPatch);

    //Response -> Question
    Question questionResponseDtoToQuestion(QuestionDto.Response questionResponse);

    //Question -> Response
    QuestionDto.Response questionToQuestionResponseDto(Question question);

    //List
    List<QuestionDto.Response> questionToQuestionResponseDtos(List<Question> questions);
}
