package com.vivarepublica.vivastackoverflow.domain.question.mapper;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    //PostDto -> Question
    Question questionPostDtoToQuestion(QuestionDto.PostDto questionPostDto);

    //PatchDto -> Question
    Question questionPatchDtoToQuestion(QuestionDto.PatchDto questionPatchDto);

    //ResponseDto -> Question
    Question questionResponseDtoToQuestion(QuestionDto.ResponseDto questionResponseDto);

    //Question -> ResponseDto
    QuestionDto.ResponseDto questionToQuestionResponseDto(Question question);

    //List
    List<QuestionDto.ResponseDto> questionToQuestionResponseDtos(List<Question> questions);
}
