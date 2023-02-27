package com.vivarepublica.vivastackoverflow.domain.question.controller;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.question.mapper.QuestionMapper;
import com.vivarepublica.vivastackoverflow.domain.question.service.QuestionService;
import com.vivarepublica.vivastackoverflow.domain.response.MultiResponseDto;
import com.vivarepublica.vivastackoverflow.util.UriCreator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionMapper questionMapper;

    private final QuestionService questionService;

    //Post
    @PostMapping
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post questionPost) {

        Question question = questionMapper.questionPostDtoToQuestion(questionPost);
        Question createdQuestion = questionService.create(question);
//        QuestionDto.Response questionResponse = questionMapper.questionToQuestionResponseDto(createdQuestion);
        URI location = UriCreator.createUri("/questions", createdQuestion.getQuestionId());
        return ResponseEntity.created(location).build();
    }

    //Patch
    @PatchMapping("/{question-id}")
    public ResponseEntity PatchQuestion(@PathVariable("question-id") @Positive Long questionId,
                                        @RequestBody QuestionDto.Patch patch) {

        patch.setQuestionId(questionId);
        Question question = questionMapper.questionPatchDtoToQuestion(patch);
        Question patchQuestion = questionService.patch(question);
        QuestionDto.Response response = questionMapper.questionToQuestionResponseDto(patchQuestion);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Get One
    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive Long questionId) {

        Question getOne = questionService.getOne(questionId);
        QuestionDto.Response response = questionMapper.questionToQuestionResponseDto(getOne);

//(stub)QuestionDto.Response getOne = new QuestionDto.Response(questionId, "제목", "내용", List.of(new String[]{"태그1", "태그2"}), 3);

        return ResponseEntity.ok(response);

    }

    //Get All
    @GetMapping
    public ResponseEntity getAll(@RequestParam int page, @RequestParam int size) {

//(stub) List<QuestionDto.Response> getAll = List.of(new QuestionDto.Response(1L, "제목1", "내용1", List.of(new String[]{"태그1", "태그2"}), 1),
//                                                      new QuestionDto.Response(2L, "제목2", "내용2", List.of(new String[]{"태그12", "태그22"}), 2),
//                                                      new QuestionDto.Response(3L, "제목3", "내용3", List.of(new String[]{"태그123", "태그223"}), 3));

        Page<Question> pageQuestions = questionService.getAll(page - 1, size);
        List<Question> responses = pageQuestions.getContent();

        return new ResponseEntity(new MultiResponseDto<>(
                questionMapper.questionToQuestionResponseDtos(responses),
                pageQuestions),
                HttpStatus.OK);

    }


    //Delete One
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteOne(@PathVariable("question-id") @Positive Long questionId){

        questionService.deleteOne(questionId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //Delete All
    @DeleteMapping
    public ResponseEntity deleteAll() {

        questionService.deleteAll();

        return ResponseEntity.noContent().build();
    }


}
