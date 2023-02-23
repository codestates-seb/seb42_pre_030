package com.vivarepublica.vivastackoverflow.domain.answer.controller;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.mapper.AnswerMapper;
import com.vivarepublica.vivastackoverflow.domain.answer.response.MultiResponseDto;
import com.vivarepublica.vivastackoverflow.domain.answer.service.AnswerService;
import com.vivarepublica.vivastackoverflow.util.UriCreator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

    // Todo: 특정 댓글 가져오기 Drop
    // Todo: 답변 출력할 때 한개로 출력하는게 아니라 목록으로 출력하는게 맞음
//    @GetMapping("/{answer-id}")
//    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive Long answerId) {
//        Answer findAnswer = service.findAnswer(answerId);
//
//        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(findAnswer) , HttpStatus.OK);
//    }

    // Todo: 특정 질문글에 답변 목록 요청 및 응답
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
