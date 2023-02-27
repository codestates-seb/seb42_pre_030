package com.vivarepublica.vivastackoverflow.domain.answer.controller;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.mapper.AnswerMapper;
import com.vivarepublica.vivastackoverflow.domain.answer.service.AnswerService;
import com.vivarepublica.vivastackoverflow.domain.response.MultiResponseDto;
import com.vivarepublica.vivastackoverflow.util.UriCreator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/answers")
@Slf4j
public class AnswerController {
    private final static String ANSWER_DEFAULT_URL = "/answers";
    private final AnswerMapper mapper;
    private final AnswerService service;

    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.Post requestBody) {
        Answer createAnswer = service.createAnswer(mapper.answerPostDtoToAnswer(requestBody));
        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createAnswer.getAnswerId());

        return ResponseEntity.created(location).build();
    }

/*    @PatchMapping("/{answers-id}")
    public ResponseEntity patchAnswer() {

        return ResponseEntity.ok(null);
    }*/


    @GetMapping("/{question-id}")
    public ResponseEntity getAnswers(@PathVariable("question-id") @Positive Long questionId, @Positive @RequestParam int page, @Positive @RequestParam int size) {
        Page<Answer> pageAnswers = service.findAnswers(questionId,page-1, size);
        List<Answer> responseList = pageAnswers.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.answerToAnswerResponseDtos(responseList), pageAnswers), HttpStatus.OK);
    }

/*    @DeleteMapping("/{answers-id}")
    public ResponseEntity deleteAnswer() {

        return ResponseEntity.noContent().build();
    }*/
}
