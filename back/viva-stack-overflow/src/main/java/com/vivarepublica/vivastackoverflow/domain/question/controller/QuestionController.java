package com.vivarepublica.vivastackoverflow.domain.question.controller;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionPatchDto;
import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionPostDto;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionResponseDto;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.question.mapper.QuestionMapper;
import com.vivarepublica.vivastackoverflow.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionMapper questionMapper;
    private final QuestionService questionService;


    //Post
    @PostMapping
    public ResponseEntity<QuestionResponseDto> postQuestion(@RequestBody QuestionPostDto questionDto) {

        Question question = questionMapper.questionPostDtoToQuestion(questionDto);
        Question createdQuestion = questionService.createQuestion(question);
        QuestionResponseDto questionResponseDto = questionMapper.questionToQuestionResponseDto(createdQuestion);

        return new ResponseEntity<>(questionResponseDto, HttpStatus.CREATED);
    }

    //Patch
    @PatchMapping("{question-id}")
    public ResponseEntity PatchQuestion(@PathVariable("question-id") @Positive Long questionId,
                                        @RequestBody QuestionPatchDto patchDto) {

        return new ResponseEntity(patchDto, HttpStatus.OK);
    }

    //Get One
    @GetMapping("{question-id}")
    public ResponseEntity GetQuestion(@PathVariable("question-id") @Positive Long questionId) {

        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    //Get All
    @GetMapping
    public ResponseEntity GetAll() {

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //Delete One
    @DeleteMapping("{question-id}")
    public ResponseEntity deleteOne(@PathVariable("question-id") @Positive Long questionId){

        return new ResponseEntity(HttpStatus.OK);
    }

    //Delete All
    @DeleteMapping
    public ResponseEntity deleteAll() {

        return new ResponseEntity(HttpStatus.OK);
    }

}
