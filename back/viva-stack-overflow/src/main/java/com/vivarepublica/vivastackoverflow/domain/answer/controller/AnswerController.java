package com.vivarepublica.vivastackoverflow.domain.answer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @PostMapping
    public ResponseEntity postAnswer() {
        return ResponseEntity.created(null).build();
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer() {
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity getAnswers() {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer() {
        return ResponseEntity.noContent().build();
    }





}
