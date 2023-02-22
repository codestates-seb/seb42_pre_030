package com.vivarepublica.vivastackoverflow.domain.answer.controller;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.mapper.AnswerMapper;
import com.vivarepublica.vivastackoverflow.domain.answer.response.MultiResponseDto;
import com.vivarepublica.vivastackoverflow.domain.answer.service.AnswerService;
import com.vivarepublica.vivastackoverflow.util.UriCreator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final static String ANSWER_DEFAULT_URL = "/answers";
    private final AnswerMapper mapper;
    private final AnswerService service;

    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerDto.Post requestBody) {
        Answer createAnswer = service.createAnswer(mapper.answerPostDtoToAnswer(requestBody));
        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createAnswer.getAnswerId());

        return ResponseEntity.created(location).build();
    }

/*    @PatchMapping("/{answers-id}")
    public ResponseEntity patchAnswer() {

        return ResponseEntity.ok(null);
    }*/

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") Long answerId) {
        Answer findAnswer = service.findAnswer(answerId);

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(findAnswer) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(@RequestParam int page, @RequestParam int size) {
//        Page<AnswerDto.Response> pageAnswers = new PageImpl<>(stubAnswerList, PageRequest.of(page, size),3); // total?? page에 넣는 컨텐츠(List)를 의미하는 것 같음, Stub
        Page<Answer> pageAnswers = service.findAnswers(page, size);
        List<Answer> responseList = pageAnswers.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.answerToAnswerResponseDtos(responseList), pageAnswers), HttpStatus.OK);
    }

/*    @DeleteMapping("/{answers-id}")
    public ResponseEntity deleteAnswer() {

        return ResponseEntity.noContent().build();
    }*/
}
