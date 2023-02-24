package com.vivarepublica.vivastackoverflow.domain.question.controller;

import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
import com.vivarepublica.vivastackoverflow.domain.response.MultiResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

//    private final QuestionMapper questionMapper;
//    private final QuestionService questionService;

    //Post
    @PostMapping
    public ResponseEntity postQuestion() {

        //@RequestBody QuestionDto.PostDto questionPostDto
//        Question question = questionMapper.questionPostDtoToQuestion(questionPostDto);
//        Question createdQuestion = questionService.createQuestion(question);
//        QuestionDto.ResponseDto questionResponseDto = questionMapper.questionToQuestionResponseDto(createdQuestion);
//
//        return new ResponseEntity<>(questionResponseDto, HttpStatus.CREATED);

        return ResponseEntity.created(URI.create("/questions/1")).build();
    }

    //Patch
    @PatchMapping("/{question-id}")
    public ResponseEntity PatchQuestion(@PathVariable("question-id") @Positive Long questionId) {
//        @PathVariable("question-id") @Positive Long questionId,
//        @RequestBody QuestionDto.PatchDto patchDto

        List<String> questionTag = new ArrayList<>();
        questionTag.add("태그1");
        questionTag.add("태그2");

        QuestionDto.ResponseDto patch = new QuestionDto.ResponseDto(questionId, "제목22", "내용22", questionTag, 3);

        return ResponseEntity.ok(patch);
    }

    //Get One
    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive Long questionId) {

        //@PathVariable("question-id") @Positive Long questionId
        //Question getOne = questionService.getOne(questionId);
        QuestionDto.ResponseDto getOne = new QuestionDto.ResponseDto(questionId, "제목", "내용", List.of(new String[]{"태그1", "태그2"}), 3);
        return ResponseEntity.ok(getOne);

    }

    //Get All
    @GetMapping
    public ResponseEntity getAll(@RequestParam int page, @RequestParam int size) {

        List<QuestionDto.ResponseDto> getAll = List.of(new QuestionDto.ResponseDto(1L, "제목1", "내용1", List.of(new String[]{"태그1", "태그2"}), 1),
                                                        new QuestionDto.ResponseDto(2L, "제목2", "내용2", List.of(new String[]{"태그12", "태그22"}), 2),
                                                        new QuestionDto.ResponseDto(3L, "제목3", "내용3", List.of(new String[]{"태그123", "태그223"}), 3));

        Page<QuestionDto.ResponseDto> pageQuestions = new PageImpl<>(getAll, PageRequest.of(page,size),3);
        List<QuestionDto.ResponseDto> responseList = pageQuestions.getContent();

        return new ResponseEntity(new MultiResponseDto<>(responseList, pageQuestions), HttpStatus.OK);
    }


    //Delete One
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteOne(@PathVariable("question-id") @Positive Long questionId){

        //@PathVariable("question-id") @Positive Long questionId
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //Delete All
    @DeleteMapping
    public ResponseEntity deleteAll() {

        return ResponseEntity.noContent().build();
    }

}
