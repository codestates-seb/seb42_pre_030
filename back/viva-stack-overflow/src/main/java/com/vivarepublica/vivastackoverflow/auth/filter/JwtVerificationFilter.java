package com.vivarepublica.vivastackoverflow.auth.filter;

import com.vivarepublica.vivastackoverflow.auth.jwt.JwtTokenizer;
import com.vivarepublica.vivastackoverflow.auth.util.CustomAuthorityUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class JwtVerificationFilter extends OncePerRequestFilter {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 헤더에서 JWT를 받아온다.
        String jws = request.getHeader("Authorization").replace("Bearer ", "");

        // 유효한 토큰인지 확인하고 사용자 속성 추출
        Map<String, Object> claims = verifyJws(request);

        // Redis에 해당 accessToken 로그아웃 여부 확인
        String isLogout = (String) redisTemplate.opsForValue().get(jws);
        // 로그아웃이 되어 있지 않은 경우(isLogout이 "logout"이 아닌 경우) 토큰 정상 작동하기
        if (ObjectUtils.isEmpty(isLogout)) {
            setAuthenticationToContext(claims);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String authorization = request.getHeader("Authorization");

        return authorization == null || !authorization.startsWith("Bearer");
    }

    private Map<String, Object> verifyJws(HttpServletRequest request) {
        String jws = request.getHeader("Authorization").replace("Bearer ", "");
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        return jwtTokenizer.getClaims(jws, base64EncodedSecretKey).getBody();
    }

    private void setAuthenticationToContext(Map<String, Object> claims) {
        String username = (String) claims.get("username");
        List<GrantedAuthority> authorities = authorityUtils.createAuthorities((List) claims.get("roles"));

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(username, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
