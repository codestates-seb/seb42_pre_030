package com.vivarepublica.vivastackoverflow.slice.question;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.vivarepublica.vivastackoverflow.domain.question.controller.QuestionController;
import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import com.vivarepublica.vivastackoverflow.domain.question.mapper.QuestionMapper;
import com.vivarepublica.vivastackoverflow.domain.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc(addFilters = false)
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper questionMapper;



// Post ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void postQuestionTest() throws Exception {

        //given

//        Set<Tag> questionTag = new HashSet<>();
//        Tag tag1 = new Tag(1L, HashTag.TAG1);
//        questionTag.add(tag1);
//
//        Set<Question> questionSet = new HashSet<>();
//        Question question = new Question(1L, "제목", "내용");
//        questionSet.add(question);

        QuestionDto.Post post = new QuestionDto.Post("제목", "내용");

        given(questionMapper.questionPostDtoToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());

        Question mockResultQuestion = new Question();
        mockResultQuestion.setQuestionId(1L);
        given(questionService.create(Mockito.any(Question.class))).willReturn(mockResultQuestion);

        String content = gson.toJson(post);
        URI uri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();


        //when -> MockMvc 객체로 테스트 대상 controller 호출

        ResultActions actions
                = mockMvc.perform(
                        MockMvcRequestBuilders
                                .post(uri)
                                            .accept(MediaType.APPLICATION_JSON)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(content)
                                                    );

        //then -> Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 Request body 검증

        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/questions"))))
                .andDo(document(
                        "post-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용")
//                                        , fieldWithPath("tag").type(JsonFieldType.ARRAY).description("태그"),
//                                        subsectionWithPath("tag.[].tagId").type(JsonFieldType.NUMBER).description("태그 ID"),
//                                        subsectionWithPath("tag.[].tagName").type(JsonFieldType.STRING).description("태그 이름"),
//                                        subsectionWithPath("tag.[].questions.[]").type(JsonFieldType.ARRAY).description("질문 배열"),
//                                        fieldWithPath("tagId").description("tagId"),
//                                        fieldWithPath("tagName").description("tagName"),
//                                        fieldWithPath("questions").description("questions")
                                )
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location Header. 등록된 리소스의 URI")
                        )
                        )
                );
    }

// Patch ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void patchQuestionTest() throws Exception {
        //given
        Long questionId = 1L;

        QuestionDto.Patch patch = new QuestionDto.Patch(0L, "제목22", "내용22");

        QuestionDto.Response response = new QuestionDto.Response(1L, "제목22", "내용22",  3);

        //stubbing by Mockito
        given(questionMapper.questionPatchDtoToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());
        given(questionService.patch(Mockito.any(Question.class))).willReturn(new Question());
        given(questionMapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(response);

        Gson gson = new Gson();
        String patchContent = gson.toJson(patch);

        //when
        ResultActions actions =
                mockMvc.perform(
                                patch("/questions/{question-id}", questionId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(patchContent)
                );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.questionId").value(response.getQuestionId()))
                .andExpect(jsonPath("$.title").value(response.getTitle()))
                .andExpect(jsonPath("$.content").value(response.getContent()))
                .andExpect(jsonPath("$.like").value(response.getLike()))
                .andDo(document(
                        "patch-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("question-id").description("질문 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용")

                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("like").type(JsonFieldType.NUMBER).description("추천수")
                                )
                        )
                ));
    }

// GetOne ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void getQuestionTest() throws Exception {
        //given
        Long questionId = 1L;

        Question question = new Question("제목", "내용");

        QuestionDto.Response response =
                new QuestionDto.Response(questionId, "제목", "내용",  3);

        given(questionService.getOne(Mockito.anyLong())).willReturn(new Question());
        given(questionMapper.questionToQuestionResponseDto(Mockito.any(Question.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(
                                        get("/questions/{question-id}", questionId)
                                                .accept(MediaType.APPLICATION_JSON)
        );

        // then

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.questionId").value(response.getQuestionId()))
                .andDo(document(
                        "getOne-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("question-id").description("질문 식별자")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("like").type(JsonFieldType.NUMBER).description("추천수")
                                )
                        )
                ));
    }

// GetAll ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void getAllQuestionTest() throws Exception {
        //given

        Question question1 = new Question("제목1", "내용1");
        question1.setLikeCount(3);

        Question question2 = new Question("제목2", "내용2");
        question2.setLikeCount(5);

        Question question3 = new Question("제목3", "내용3");
        question3.setLikeCount(7);

        Page<Question> pageQuestions =
                new PageImpl<>(List.of(question1, question2, question3),
                        PageRequest.of(0, 10,
                        Sort.by("questionId").descending()), 3);

        List<QuestionDto.Response> questions
                = List.of
                (new QuestionDto.Response(1L, "제목1", "내용1", 3),
                new QuestionDto.Response(2L, "제목2", "내용2", 5),
                new QuestionDto.Response(3L, "제목3", "내용3", 7)
        );

        //stubbing by Mockito
        given(questionService.getAll(Mockito.anyInt(), Mockito.anyInt()))
                .willReturn(pageQuestions);
        given(questionMapper.questionToQuestionResponseDtos(Mockito.anyList()))
                .willReturn(questions);

        String page = "1";
        String size = "10";
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        URI uri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();


        //when
        ResultActions actions =
                mockMvc.perform(
                        get(uri)
                                .params(queryParams)
                                .accept(MediaType.APPLICATION_JSON)
                );

        //then
        MvcResult result = actions
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.data").isArray())
                                .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");

        assertThat(list.size(), is(3));

        actions.andDo(document(
                "getAll-questions",
                getRequestPreProcessor(),
                getResponsePreProcessor(),
                requestParameters(
                        List.of(
                                parameterWithName("page").description("페이지"),
                                parameterWithName("size").description("사이즈")
                        )),
                responseFields(
                        List.of(
                                fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                fieldWithPath("data[].title").type(JsonFieldType.STRING).description("질문 제목"),
                                fieldWithPath("data[].content").type(JsonFieldType.STRING).description("질문 내용"),
                                fieldWithPath("data[].like").type(JsonFieldType.NUMBER).description("추천수"),

                                fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 수"),
                                fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 사이즈"),
                                fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("총 요소"),
                                fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("총 페이지")

                        )
                )
        ));
    }

// DeleteOne ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void deleteQuestionTest() throws Exception {
        //given

        Long questionId = 1L;

        //stubbing by Mockito
        doNothing().when(questionService).deleteOne(questionId);

        //when
        ResultActions actions
                = mockMvc.perform(
                delete("/questions/{question-id}", questionId)
        );

        //then
        actions
                .andExpect(status().isNoContent())
                .andDo(document(
                        "deleteOne-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("question-id").description("삭제할 질문 식별자")
                        )
                ));
    }

// DeleteAll ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void  deleteAllQuestionTest() throws Exception {
        //given

        //stubbing by Mockito
        doNothing().when(questionService).deleteAll();

        //when //then
        mockMvc.perform(
                delete("/questions"))
                .andExpect(status().isNoContent())
                .andDo(document(
                        "deleteAll-questions",
                        getRequestPreProcessor(),
                        getResponsePreProcessor()

                ));
    }
}
