package com.vivarepublica.vivastackoverflow.domain.question.mapper;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionPatchDto;
import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionPostDto;
import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionResponseDto;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    //PostDto -> Question
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    //PatchDto -> Question
    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    //ResponseDto -> Question
    Question questionResponseDtoToQuestion(QuestionResponseDto questionResponseDto);

    //Question -> ResponseDto
    QuestionResponseDto questionToQuestionResponseDto(Question question);

    //List
    List<QuestionResponseDto> questionToQuestionResponseDtos(List<Question> questions);


}
