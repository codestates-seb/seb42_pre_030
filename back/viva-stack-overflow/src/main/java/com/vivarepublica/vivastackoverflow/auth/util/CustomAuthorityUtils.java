package com.vivarepublica.vivastackoverflow.auth.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomAuthorityUtils {
    private final List<String> USER_ROLES_STRING = List.of("USER");

    public List<String> createRoles() {
        return USER_ROLES_STRING;
    }
}
