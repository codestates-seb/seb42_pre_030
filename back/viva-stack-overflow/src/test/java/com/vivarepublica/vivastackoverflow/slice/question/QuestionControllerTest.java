package com.vivarepublica.vivastackoverflow.slice.question;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.vivarepublica.vivastackoverflow.domain.question.dto.QuestionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

// Post ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void postQuestionTest() throws Exception {

        //given -> 테스트용 requestbody 생성

        QuestionDto.PostDto post = new QuestionDto.PostDto("제목", "내용", List.of(new String[]{"태그1", "태그2"}));
        String content = gson.toJson(post);

        //when -> MockMvc 객체로 테스트 대상 controller 호출

        ResultActions actions = mockMvc.perform(
                                                    post("/questions")
                                                            .accept(MediaType.APPLICATION_JSON)
                                                            .contentType(MediaType.APPLICATION_JSON)
                                                            .content(content)
                                                    );

        //then -> Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 Request body 검증

        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/questions"))));
    }

// Patch ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void patchQuestionTest() throws Exception {
        //given

        QuestionDto.ResponseDto response = new QuestionDto.ResponseDto(1L, "제목", "내용", List.of(new String[]{"태그1", "태그2"}), 3);
        String responseContent = gson.toJson(response);
        URI responseUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();

        ResultActions postActions =
                mockMvc.perform(
                        post(responseUri)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(responseContent)
                );

        long questionId;
        String location = postActions.andReturn().getResponse().getHeader("Location");
        questionId = Long.parseLong(location.substring(location.lastIndexOf("/") + 1));

        QuestionDto.PatchDto patch = new QuestionDto.PatchDto(questionId, "제목22", "내용22", List.of(new String[]{"태그1", "태그2"}));

        String patchContent = gson.toJson(patch);

        URI patchUri = UriComponentsBuilder.newInstance().path("/questions/{question-id}").buildAndExpand(questionId).toUri();

        //when
        ResultActions actions =
                mockMvc.perform(
                                patch(patchUri)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(patchContent)
                );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.questionId").value(patch.getQuestionId()));
    }

// GetOne ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void getQuestionTest() throws Exception {
        //given
        // -- post 이용한 테스트 데이터 생성 시작

/*      QuestionDto.PostDto post = new QuestionDto.PostDto("제목", "내용", List.of(new String[]{"태그1", "태그2"}));
        String postContent = gson.toJson(post);

        System.out.println("postContent = " + postContent);

        ResultActions postActions =
                mockMvc.perform(
                        post("/questions")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postContent)
                );
        // -- post 이용 테스트 데이터 생성 끝
*/
        Long questionId = 1L;
        QuestionDto.ResponseDto response =
                new QuestionDto.ResponseDto(questionId, "제목", "내용", List.of(new String[]{"태그1", "태그2"}), 3);


/*      long questionId;
        String location = postActions.andReturn().getResponse().getHeader("Location");
        questionId = Long.parseLong(location.substring(location.lastIndexOf("/") + 1));

        URI getUri = UriComponentsBuilder.newInstance().path("/questions/{question-id}").buildAndExpand(questionId).toUri();

        System.out.println("getUri = " + getUri);
*/

        // when
        ResultActions actions = mockMvc.perform(
                                        get("/questions/{question-id}", questionId)
                                                .accept(MediaType.APPLICATION_JSON)
        );

        // then

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.questionId").value(response.getQuestionId()));
/*        mockMvc.perform(
                get(getUri)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(post.getTitle()))
                .andExpect(jsonPath("$.content").value(post.getContent()))
                .andExpect(jsonPath("$.tag").value(post.getTag()));
 */

    }

// GetAll ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void getAllQuestionTest() throws Exception {
        //given
        QuestionDto.ResponseDto response1 = new QuestionDto.ResponseDto(1L, "제목1", "내용1", List.of(new String[]{"태그1", "태그2"}), 1);
        String responseContent1 = gson.toJson(response1);
        URI requestUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();

        mockMvc.perform(
                post(requestUri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(responseContent1)
        );

        QuestionDto.ResponseDto response2 = new QuestionDto.ResponseDto(2L, "제목2", "내용2", List.of(new String[]{"태그12", "태그22"}), 2);
        String responseContent2 = gson.toJson(response2);

        mockMvc.perform(
                post(requestUri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(responseContent2)
        );

        QuestionDto.ResponseDto response3 = new QuestionDto.ResponseDto(3L, "제목3", "내용3", List.of(new String[]{"태그123", "태그223"}), 3);
        String responseContent3 = gson.toJson(response3);

        mockMvc.perform(
                post(requestUri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(responseContent3)
        );

//        List<QuestionDto.ResponseDto> responseList
//                = List.of(new QuestionDto.ResponseDto(1L, "제목1", "내용1", List.of(new String[]{"태그1", "태그2"}), 1),
//                new QuestionDto.ResponseDto(2L, "제목2", "내용2", List.of(new String[]{"태그12", "태그22"}), 2),
//                new QuestionDto.ResponseDto(3L, "제목3", "내용3", List.of(new String[]{"태그123", "태그223"}), 3)
//                );

        String page = "1";
        String size = "10";
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

//        Page<QuestionDto.ResponseDto> pageQuestions = new PageImpl<>(responseList, PageRequest.of(1,10),3);

        URI getUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();

        //when
        ResultActions actions =
                mockMvc.perform(
                        get(getUri)
                                .params(queryParams)
                                .accept(MediaType.APPLICATION_JSON)
                );

        //then
        MvcResult result = actions
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$").isArray())
                                .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$");

        assertThat(list.size(), is(3));
    }

// DeleteOne ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void deleteQuestionTest() throws Exception {
        //given
        QuestionDto.PostDto post = new QuestionDto.PostDto("제목", "내용", List.of(new String[]{"태그1", "태그2"}));
        String postContent = gson.toJson(post);
        URI postUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();

        ResultActions postActions =
                mockMvc.perform(
                        post(postUri)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postContent)
                );

        long questionId;
        String location = postActions.andReturn().getResponse().getHeader("Location");
        questionId = Long.parseLong(location.substring(location.lastIndexOf("/") + 1));

        URI uri = UriComponentsBuilder.newInstance().path("/questions/{question-id}").buildAndExpand(questionId).toUri();

        //when //then
        mockMvc.perform(delete(uri))
                .andExpect(status().isNoContent());


    }

// DeleteAll ---------------------------------------------------------------------------------------------------------------------

    @Test
    public void  deleteAllQuestionTest() throws Exception {
        //given
        QuestionDto.PostDto post1 = new QuestionDto.PostDto("제목", "내용", List.of(new String[]{"태그1", "태그2"}));
        String postContent1 = gson.toJson(post1);
        URI postUri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();

        mockMvc.perform(
                post(postUri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postContent1)
        );

        QuestionDto.PostDto post2 = new QuestionDto.PostDto("제목2", "내용2", List.of(new String[]{"태그12", "태그22"}));
        String postContent2 = gson.toJson(post2);

        mockMvc.perform(
                post(postUri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postContent2)
        );

        QuestionDto.PostDto post3 = new QuestionDto.PostDto("제목3", "내용3", List.of(new String[]{"태그123", "태그223"}));
        String postContent3 = gson.toJson(post3);

        mockMvc.perform(
                post(postUri)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postContent3)
        );

        String page = "1";
        String size = "10";
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        URI uri = UriComponentsBuilder.newInstance().path("/questions").build().toUri();

        //when //then
        mockMvc.perform(delete(uri))
                .andExpect(status().isNoContent());
    }
}
