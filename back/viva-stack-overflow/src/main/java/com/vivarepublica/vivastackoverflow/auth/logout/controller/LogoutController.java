package com.vivarepublica.vivastackoverflow.auth.logout.controller;

import com.vivarepublica.vivastackoverflow.auth.logout.service.LogoutService;
import com.vivarepublica.vivastackoverflow.auth.logout.dto.LogoutDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/logoutPath")
public class LogoutController {
    private final LogoutService logoutService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void postLogout(@RequestBody LogoutDto logoutDto) {
        logoutService.logout(logoutDto);
    }
}
