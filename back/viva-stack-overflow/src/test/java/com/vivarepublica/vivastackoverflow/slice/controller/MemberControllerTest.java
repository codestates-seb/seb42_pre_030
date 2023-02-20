package com.vivarepublica.vivastackoverflow.slice.controller;

import com.google.gson.Gson;
import com.vivarepublica.vivastackoverflow.domain.member.controller.MemberController;
import com.vivarepublica.vivastackoverflow.domain.member.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;

    @Test
    void postMemberTest() throws Exception {
        // given
        MemberDto.Post postMemberDto =
                new MemberDto.Post("walter@gmail.com", "a1234567", "Heisenberg");

        String postContent = gson.toJson(postMemberDto);

        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postContent)
                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is("/members/1")));
    }

    @Test
    void getMemberTest() throws Exception {
        // given
        Long memberId = 1L;
        MemberDto.Response response =
                new MemberDto.Response(memberId, "frank@gmail.com", "francis");

        // when
        ResultActions actions =
                mockMvc.perform(
                        get("/members/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(response.getMemberId()));
    }

    @Test
    void deleteMemberTest() throws Exception {
        // given
        Long memberId = 1L;

        // when
        ResultActions actions =
                mockMvc.perform(
                        delete("/members/{member-id}", memberId)
                );

        // then
        actions
                .andExpect(status().isNoContent());
    }
}
