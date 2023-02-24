package com.vivarepublica.vivastackoverflow.slice.answer;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.vivarepublica.vivastackoverflow.domain.answer.controller.AnswerController;
import com.vivarepublica.vivastackoverflow.domain.answer.dto.AnswerDto;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.answer.mapper.AnswerMapper;
import com.vivarepublica.vivastackoverflow.domain.answer.repository.AnswerRepository;
import com.vivarepublica.vivastackoverflow.domain.answer.service.AnswerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnswerController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc(addFilters = false)
public class AnswerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private AnswerService answerService;

    @MockBean
    private AnswerMapper answerMapper;

    @Test
    public void postAnswerTest() throws Exception {
        // given
        AnswerDto.Post post = new AnswerDto.Post(1L, 1L, "Answer Post 테스트 입니다.");
        String content = gson.toJson(post);

        given(answerMapper.answerPostDtoToAnswer(Mockito.any(AnswerDto.Post.class))).willReturn(new Answer());

        Answer mockResultAnswer = new Answer();
        mockResultAnswer.setAnswerId(1L);

        given(answerService.createAnswer(Mockito.any(Answer.class))).willReturn(mockResultAnswer);

        // when
        ResultActions postAction =
                mockMvc.perform(
                        post("/answers")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        postAction
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/answers/"))))
                .andDo(document(
                "post-answer",
                getRequestPreProcessor(),
                getResponsePreProcessor(),
                requestFields(
                                fieldWithPath("content").type(JsonFieldType.STRING).description("답변내용")
                ),
                responseHeaders(
                        headerWithName(HttpHeaders.LOCATION).description("Location header. 등록된 리소스의 URI")
                )
        ));
    }

    // Todo: 특정 댓글 가져오기 Drop
//    @Test
//    public void getAnswerTest() throws Exception {
//        // given
//        AnswerDto.Response response = new AnswerDto.Response(1L, "세계에서 제일 멋있는 답변");
//
//        // 아직 사용하는 Bean이 없기 때문에 Mockito 필요없음
//
//        // when
//        ResultActions getActions =
//                mockMvc.perform(
//                        get("/answers/{answer-id}", 1L)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//
//        // then
//        getActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.answerId").value(response.getAnswerId()))
//                .andExpect(jsonPath("$.content").value(response.getContent()))
//                .andDo(document(
//                        "get-answer",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                            parameterWithName("answer-id").description("답변 식별자 ID")
//                        ),
//                        responseFields(
//                                List.of(fieldWithPath("answerId").type(JsonFieldType.NUMBER).description("답변 식별자 ID"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("답변 내용"))
//                )));
//    }

    @Test
    public void getAnswersTest() throws Exception {
        // given
        String page = "1";
        String size = "10";

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        List<Answer> answers = List.of(new Answer("Answer Get 태스트 입니다"),
                new Answer("Answer Get 태스트 입니다"),
                new Answer("Answer Get 태스트 입니다"),
                new Answer("Answer Get 태스트 입니다"),
                new Answer("Answer Get 태스트 입니다"),
                new Answer("Answer Get 태스트 입니다"));

        Page<Answer> pageAnswers = new PageImpl<>(answers, PageRequest.of(0, 10),answers.size());

        List<AnswerDto.Response> responseAnswerList = List.of(new AnswerDto.Response(1L, "Answer Get 태스트 입니다", 1L, "test1@gmai5.com", "testUser1"),
                new AnswerDto.Response(2L, "Answer Get 태스트 입니다", 2L, "test2@gmai5.com", "testUser2"),
                new AnswerDto.Response(3L, "Answer Get 태스트 입니다", 3L, "test3@gmai5.com", "testUser3"),
                new AnswerDto.Response(3L, "Answer Get 태스트 입니다", 4L, "test4@gmai5.com", "testUser4"),
                new AnswerDto.Response(3L, "Answer Get 태스트 입니다", 5L, "test5@gmai5.com", "testUser5"));

        given(answerService.findAnswers(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt())).willReturn(pageAnswers);
        given(answerMapper.answerToAnswerResponseDtos(Mockito.anyList())).willReturn(responseAnswerList);

        // when
        ResultActions getsActions =
                mockMvc.perform(
                        get("/answers")
                                .accept(MediaType.APPLICATION_JSON)
                                .params(queryParams)
                );

        // then
        MvcResult mvcResult = getsActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andReturn();

        List list = JsonPath.parse(mvcResult.getResponse().getContentAsString()).read("$.data"); // mvcResult.getResponse().getContentAsString()으로 ResponseBody 값을 Json으로 parse하고 "$.data"부분만 가져온다.
        assertThat(list.size(), is(5)); // 가져온 Json 배열의 수가 5칸인지 테스트

        getsActions.andDo(document(
                "get-answers",
                getRequestPreProcessor(),
                getResponsePreProcessor(),
                requestParameters(
                        List.of(
                        parameterWithName("page").description("Page 번호(0부터 시작하는 페이지 인덱스)"),
                        parameterWithName("size").description("Size 크기(반환할 페이지의 크기)"))),
                responseFields(
                        List.of(fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                fieldWithPath("data[].answerId").type(JsonFieldType.NUMBER).description("답변 식별자 ID"),
                                fieldWithPath("data[].content").type(JsonFieldType.STRING).description("답변 내용"),

                                fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 수"),
                                fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 크기"),
                                fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("총 요소"),
                                fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("총 페이지"))
                )));
    }

}
