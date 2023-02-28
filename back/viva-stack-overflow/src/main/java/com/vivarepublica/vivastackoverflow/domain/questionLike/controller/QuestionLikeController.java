package com.vivarepublica.vivastackoverflow.domain.questionLike.controller;

import com.vivarepublica.vivastackoverflow.domain.questionLike.dto.QuestionLikeDto;
import com.vivarepublica.vivastackoverflow.domain.questionLike.service.QuestionLikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/questions/like")
@AllArgsConstructor
public class QuestionLikeController {

    private final QuestionLikeService questionLikeService;

    @PostMapping
    public ResponseEntity post(@RequestBody @Valid QuestionLikeDto questionLikeDto) throws Exception {
        QuestionLikeDto postLike = questionLikeService.post(questionLikeDto);
        return ResponseEntity.ok(postLike);
    }

}
