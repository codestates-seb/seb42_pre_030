//package com.vivarepublica.vivastackoverflow.slice.question;
//
//import com.google.gson.Gson;
//import com.jayway.jsonpath.JsonPath;
//import com.vivarepublica.vivastackoverflow.domain.question.controller.QuestionController;
//import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getRequestPreProcessor;
//import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getResponsePreProcessor;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.startsWith;
//import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
//import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(QuestionController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//@AutoConfigureMockMvc(addFilters = false)
//public class QuestionControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//
//
//// Post ---------------------------------------------------------------------------------------------------------------------
//
//    @Test
//    public void postQuestionTest() throws Exception {
//
//        //given -> 테스트용 requestbody 생성
//
//        QuestionDto.Post post = new QuestionDto.Post("제목", "내용", List.of(new String[]{"태그1", "태그2"}));
//        String content = gson.toJson(post);
//
//        //when -> MockMvc 객체로 테스트 대상 controller 호출
//
//        ResultActions actions = mockMvc.perform(
//                                                    post("/questions")
//                                                            .accept(MediaType.APPLICATION_JSON)
//                                                            .contentType(MediaType.APPLICATION_JSON)
//                                                            .content(content)
//                                                    );
//
//        //then -> Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 Request body 검증
//
//        actions
//                .andExpect(status().isCreated())
//                .andExpect(header().string("Location", is(startsWith("/questions"))))
//                .andDo(document(
//                        "post-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tag").type(JsonFieldType.ARRAY).description("태그")
//                                )
//                        ),
//                        responseHeaders(
//                                headerWithName(HttpHeaders.LOCATION).description("Location Header. 등록된 리소스의 URI")
//                        )
//
//
//                ));
//    }
//
//// Patch ---------------------------------------------------------------------------------------------------------------------
//
//    @Test
//    public void patchQuestionTest() throws Exception {
//        //given
//
//        List<String> questionTag = new ArrayList<>();
//        questionTag.add("태그1");
//        questionTag.add("태그2");
//
//        QuestionDto.Patch request = new QuestionDto.Patch(1L, "제목22", "내용22", questionTag);
//
////        String requestContent = gson.toJson(request);
////        URI requestUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();
////
////        ResultActions postActions =
////                mockMvc.perform(
////                        post(requestUri)
////                                .accept(MediaType.APPLICATION_JSON)
////                                .contentType(MediaType.APPLICATION_JSON)
////                                .content(requestContent)
////                );
//
////        long questionId;
////        String location = postActions.andReturn().getResponse().getHeader("Location");
////        questionId = Long.parseLong(location.substring(location.lastIndexOf("/") + 1));
//
//        QuestionDto.Response response = new QuestionDto.Response(1L, "제목22", "내용22", questionTag,  3);
//        String patchContent = gson.toJson(request);
//
//        //URI responseUri = UriComponentsBuilder.newInstance().path("/questions/{question-id}").buildAndExpand().toUri();
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                                patch("/questions/{question-id}", 1L)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(patchContent)
//                );
//
//        //then
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.questionId").value(response.getQuestionId()))
//                .andExpect(jsonPath("$.title").value(response.getTitle()))
//                .andExpect(jsonPath("$.content").value(response.getContent()))
//                .andExpect(jsonPath("$.tag").value(response.getTag()))
//                .andExpect(jsonPath("$.like").value(response.getLike()))
//                .andDo(document(
//                        "patch-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("질문 식별자")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목").optional(),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용").optional(),
//                                        fieldWithPath("tag").type(JsonFieldType.ARRAY).description("태그").optional()
//
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tag").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("like").type(JsonFieldType.NUMBER).description("추천수").optional()
//                                )
//                        )
//                ));
//    }
//
//// GetOne ---------------------------------------------------------------------------------------------------------------------
//
//    @Test
//    public void getQuestionTest() throws Exception {
//        //given
//        // -- post 이용한 테스트 데이터 생성 시작
//
///*      QuestionDto.Post post = new QuestionDto.Post("제목", "내용", List.of(new String[]{"태그1", "태그2"}));
//        String postContent = gson.toJson(post);
//
//        System.out.println("postContent = " + postContent);
//
//        ResultActions postActions =
//                mockMvc.perform(
//                        post("/questions")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(postContent)
//                );
//        // -- post 이용 테스트 데이터 생성 끝
//*/
//        Long questionId = 1L;
//
//        List<String> questionTag = new ArrayList<>();
//        questionTag.add("태그1");
//        questionTag.add("태그2");
//
//        QuestionDto.Response response =
//                new QuestionDto.Response(questionId, "제목", "내용", questionTag, 3);
//
//
///*      long questionId;
//        String location = postActions.andReturn().getResponse().getHeader("Location");
//        questionId = Long.parseLong(location.substring(location.lastIndexOf("/") + 1));
//
//        URI getUri = UriComponentsBuilder.newInstance().path("/questions/{question-id}").buildAndExpand(questionId).toUri();
//
//        System.out.println("getUri = " + getUri);
//*/
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                                        get("/questions/{question-id}", questionId)
//                                                .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.questionId").value(response.getQuestionId()))
//                .andDo(document(
//                        "getOne-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("질문 식별자")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
//                                        fieldWithPath("content").type(JsonFieldType.STRING).description("내용"),
//                                        fieldWithPath("tag").type(JsonFieldType.ARRAY).description("태그"),
//                                        fieldWithPath("like").type(JsonFieldType.NUMBER).description("추천수")
//                                )
//                        )
//
//
//                ));
///*        mockMvc.perform(
//                get(getUri)
//                        .accept(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value(post.getTitle()))
//                .andExpect(jsonPath("$.content").value(post.getContent()))
//                .andExpect(jsonPath("$.tag").value(post.getTag()));
// */
//
//    }
//
//// GetAll ---------------------------------------------------------------------------------------------------------------------
//
//    @Test
//    public void getAllQuestionTest() throws Exception {
//        //given
////        QuestionDto.Response response1 = new QuestionDto.Response(1L, "제목1", "내용1", List.of(new String[]{"태그1", "태그2"}), 1);
////        String responseContent1 = gson.toJson(response1);
////        URI requestUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();
////
////        mockMvc.perform(
////                post(requestUri)
////                        .accept(MediaType.APPLICATION_JSON)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(responseContent1)
////        );
////
////        QuestionDto.Response response2 = new QuestionDto.Response(2L, "제목2", "내용2", List.of(new String[]{"태그12", "태그22"}), 2);
////        String responseContent2 = gson.toJson(response2);
////
////        mockMvc.perform(
////                post(requestUri)
////                        .accept(MediaType.APPLICATION_JSON)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(responseContent2)
////        );
////
////        QuestionDto.Response response3 = new QuestionDto.Response(3L, "제목3", "내용3", List.of(new String[]{"태그123", "태그223"}), 3);
////        String responseContent3 = gson.toJson(response3);
////
////        mockMvc.perform(
////                post(requestUri)
////                        .accept(MediaType.APPLICATION_JSON)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(responseContent3)
////        );
//
////        List<QuestionDto.Response> responseList
////                = List.of(new QuestionDto.Response(1L, "제목1", "내용1", List.of(new String[]{"태그1", "태그2"}), 1),
////                new QuestionDto.Response(2L, "제목2", "내용2", List.of(new String[]{"태그12", "태그22"}), 2),
////                new QuestionDto.Response(3L, "제목3", "내용3", List.of(new String[]{"태그123", "태그223"}), 3)
////                );
//
//        String page = "1";
//        String size = "10";
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", page);
//        queryParams.add("size", size);
//
////        Page<QuestionDto.Response> pageQuestions = new PageImpl<>(responseList, PageRequest.of(1,10),3);
//
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/questions")
//                                .params(queryParams)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//
//        //then
//        MvcResult result = actions
//                                .andExpect(status().isOk())
//                                .andExpect(jsonPath("$.data").isArray())
//                                .andReturn();
//
//        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");
//
//        assertThat(list.size(), is(3));
//
//        actions.andDo(document(
//                "getAll-questions",
//                getRequestPreProcessor(),
//                getResponsePreProcessor(),
//                requestParameters(
//                        List.of(
//                                parameterWithName("page").description("페이지"),
//                                parameterWithName("size").description("사이즈")
//                        )),
//                responseFields(
//                        List.of(
//                                fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
//                                fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                fieldWithPath("data[].title").type(JsonFieldType.STRING).description("질문 제목"),
//                                fieldWithPath("data[].content").type(JsonFieldType.STRING).description("질문 내용"),
//                                fieldWithPath("data[].tag").type(JsonFieldType.ARRAY).description("태그"),
//                                fieldWithPath("data[].like").type(JsonFieldType.NUMBER).description("추천수"),
//
//                                fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
//                                fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 수"),
//                                fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 사이즈"),
//                                fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("총 요소"),
//                                fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("총 페이지")
//
//                        )
//                )
//        ));
//    }
//
//// DeleteOne ---------------------------------------------------------------------------------------------------------------------
//
//    @Test
//    public void deleteQuestionTest() throws Exception {
//        //given
//
//        Long questionId = 1L;
//
////        String postContent = gson.toJson(post);
////        URI postUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();
////
////        ResultActions postActions =
////                mockMvc.perform(
////                        post(postUri)
////                                .accept(MediaType.APPLICATION_JSON)
////                                .contentType(MediaType.APPLICATION_JSON)
////                                .content(postContent)
////                );
////
////        long questionId;
////        String location = postActions.andReturn().getResponse().getHeader("Location");
////        questionId = Long.parseLong(location.substring(location.lastIndexOf("/") + 1));
////
////        URI uri = UriComponentsBuilder.newInstance().path("/questions/{question-id}").buildAndExpand(questionId).toUri();
//
//        //when
//        ResultActions actions
//                = mockMvc.perform(
//                delete("/questions/{question-id}", questionId)
//        );
//
//        //then
//        actions
//                .andExpect(status().isNoContent())
//                .andDo(document(
//                        "deleteOne-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("question-id").description("삭제할 질문 식별자")
//                        )
//                ));
//    }
//
//// DeleteAll ---------------------------------------------------------------------------------------------------------------------
//
//    @Test
//    public void  deleteAllQuestionTest() throws Exception {
//        //given
////        QuestionDto.Post post1 = new QuestionDto.Post("제목", "내용", List.of(new String[]{"태그1", "태그2"}));
////        String postContent1 = gson.toJson(post1);
////        URI postUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();
////
////        mockMvc.perform(
////                post(postUri)
////                        .accept(MediaType.APPLICATION_JSON)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(postContent1)
////        );
////
////        QuestionDto.Post post2 = new QuestionDto.Post("제목2", "내용2", List.of(new String[]{"태그12", "태그22"}));
////        String postContent2 = gson.toJson(post2);
////
////        mockMvc.perform(
////                post(postUri)
////                        .accept(MediaType.APPLICATION_JSON)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(postContent2)
////        );
////
////        QuestionDto.Post post3 = new QuestionDto.Post("제목3", "내용3", List.of(new String[]{"태그123", "태그223"}));
////        String postContent3 = gson.toJson(post3);
////
////        mockMvc.perform(
////                post(postUri)
////                        .accept(MediaType.APPLICATION_JSON)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(postContent3)
////        );
//
////        String page = "1";
////        String size = "10";
////        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
////        queryParams.add("page", page);
////        queryParams.add("size", size);
////
////        URI uri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();
//
//        //when //then
//        mockMvc.perform(
//                delete("/questions"))
//                .andExpect(status().isNoContent())
//                .andDo(document(
//                        "deleteAll-questions",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor()
//
//                ));
//    }
//}
