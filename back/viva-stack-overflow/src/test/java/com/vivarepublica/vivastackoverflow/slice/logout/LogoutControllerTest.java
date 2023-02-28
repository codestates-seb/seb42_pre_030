package com.vivarepublica.vivastackoverflow.slice.logout;

import com.google.gson.Gson;
import com.vivarepublica.vivastackoverflow.auth.logout.controller.LogoutController;
import com.vivarepublica.vivastackoverflow.auth.logout.dto.LogoutDto;
import com.vivarepublica.vivastackoverflow.auth.logout.service.LogoutService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.vivarepublica.vivastackoverflow.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LogoutController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc(addFilters = false)
public class LogoutControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private LogoutService logoutService;

    @Test
    void postLogoutTest() throws Exception {
        // given
        LogoutDto logoutDto = new LogoutDto(
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJVU0VSIl0sInVzZXJuYW1lIjoiZnJhbmtAZ21haWwuY29tIiwic3ViIjoiZnJhbmtAZ21haWwuY29tIiwiaWF0IjoxNjc3MTM5NjYwLCJleHAiOjE2NzcxNDE0NjB9.UtSnv_VuHlRSIorcglyAi3bfdePdnllBEBjsQSa7dW8"
        );

        String postContent = gson.toJson(logoutDto);

        doNothing().when(logoutService).logout(Mockito.any(LogoutDto.class));

        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/auth/logout")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postContent)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andDo(document(
                        "post-logout",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                fieldWithPath("accessToken").type(JsonFieldType.STRING).description("로그인 후 발급받은 AccessToken")
                        )
                ));
    }
}
