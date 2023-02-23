package com.vivarepublica.vivastackoverflow.auth.controller;

import com.vivarepublica.vivastackoverflow.auth.service.LogoutService;
import com.vivarepublica.vivastackoverflow.auth.dto.LogoutDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
