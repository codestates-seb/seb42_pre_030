package com.vivarepublica.vivastackoverflow.domain.answer.controller;

import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.response.MultiResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerDto.Post requestBody) {
//        URI location = UriComponentsBuilder.newInstance().path("/answers" + "/{resource-id}").buildAndExpand(resourceId).toUri();
        URI location = URI.create("/answers/1"); // Stub

        return ResponseEntity.created(location).build();
    }

/*    @PatchMapping("/{answers-id}")
    public ResponseEntity patchAnswer() {

        return ResponseEntity.ok(null);
    }*/

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") Long answerId) {
        AnswerDto.Response response = new AnswerDto.Response("세계에서 제일 멋있는 답변"); // Stub

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(@RequestParam int page, @RequestParam int size) {
        List<AnswerDto.Response> stubAnswerList = List.of(new AnswerDto.Response("세계에서 제일 멋있는 답변"),
                new AnswerDto.Response("세계에서 제일 예쁜 답변"),
                new AnswerDto.Response("세계에서 제일 짜증나는 답변")); // Stub

        Page<AnswerDto.Response> pageAnswers = new PageImpl<>(stubAnswerList, PageRequest.of(page, size),3); // total?? page에 넣는 컨텐츠(List)를 의미하는 것 같음, Stub
        List<AnswerDto.Response> responseList = pageAnswers.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(responseList, pageAnswers), HttpStatus.OK);
    }

/*    @DeleteMapping("/{answers-id}")
    public ResponseEntity deleteAnswer() {

        return ResponseEntity.noContent().build();
    }*/
}
