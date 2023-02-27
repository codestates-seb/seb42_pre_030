package com.vivarepublica.vivastackoverflow.slice.member;

import com.google.gson.Gson;
import com.vivarepublica.vivastackoverflow.domain.member.controller.MemberController;
import com.vivarepublica.vivastackoverflow.domain.member.dto.MemberDto;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.member.mapper.MemberMapper;
import com.vivarepublica.vivastackoverflow.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc(addFilters = false)
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private MemberService memberService;
    @MockBean
    private MemberMapper mapper;

    @Test
    void postMemberTest() throws Exception {
        // given
        MemberDto.Post postMemberDto =
                new MemberDto.Post("walter@gmail.com", "a1234567", "Heisenberg");

        String postContent = gson.toJson(postMemberDto);

        given(mapper.memberPostDtoToMember(Mockito.any(MemberDto.Post.class)))
                .willReturn(new Member());

        Member createdMember = new Member();
        createdMember.setMemberId(1L);

        given(memberService.createMember(Mockito.any(Member.class)))
                .willReturn(createdMember);

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
                .andExpect(header().string("Location", is("/members/1")))
                .andDo(document(
                        "post-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("별명")
                                )
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location header. 등록된 리소스의 URI")
                        )
                ));
    }

    @Test
    void patchMemberTest() throws Exception {
        // given
        Long memberId = 1L;

        MemberDto.Patch patchMemberDto =
                new MemberDto.Patch(memberId, "kimWexler");
        String patchContent = gson.toJson(patchMemberDto);

        MemberDto.Response responseBody =
                new MemberDto.Response(memberId, "kim@gmail.com", "kimWexler");

        given(mapper.memberPatchDtoToMember(Mockito.any(MemberDto.Patch.class)))
                .willReturn(new Member());

        given(memberService.updateMember(Mockito.any(Member.class)))
                .willReturn(new Member());

        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class)))
                .willReturn(responseBody);

        // when
        ResultActions actions =
                mockMvc.perform(
                        patch("/members/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(patchContent)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("nickname").value(responseBody.getNickname()))
                .andDo(document(
                        "patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("수정할 회원의 아이디")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("수정할 회원의 아이디").ignored(),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("수정하고 싶은 별명")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 아이디"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("별명")
                                )
                        )
                ));
    }

    @Test
    void getMemberTest() throws Exception {
        // given
        Long memberId = 1L;
        MemberDto.Response responseBody =
                new MemberDto.Response(memberId, "frank@gmail.com", "francis");

        given(memberService.findMember(Mockito.anyLong()))
                .willReturn(new Member());

        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class)))
                .willReturn(responseBody);

        // when
        ResultActions actions =
                mockMvc.perform(
                        get("/members/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(responseBody.getMemberId()))
                .andDo(document(
                        "get-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("조회할 회원의 아이디")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 아이디"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("별명")
                                )
                        )
                ));
    }

    @Test
    void deleteMemberTest() throws Exception {
        // given
        Long memberId = 1L;

        doNothing().when(memberService).deleteMember(Mockito.anyLong());

        // when
        ResultActions actions =
                mockMvc.perform(
                        delete("/members/{member-id}", memberId)
                );

        // then
        actions
                .andExpect(status().isNoContent())
                .andDo(document(
                        "delete-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("삭제할 회원의 아이디")
                        )
                ));
    }
}
