package com.vivarepublica.vivastackoverflow.auth.filter;

import com.vivarepublica.vivastackoverflow.auth.jwt.JwtTokenizer;
import com.vivarepublica.vivastackoverflow.auth.util.CustomAuthorityUtils;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
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
        // 앞의 Bearer를 제거한 순수한 accessToken
        String jws = request.getHeader("Authorization").replace("Bearer ", "");
        // 유효한 토큰인지 확인하고 사용자 속성 추출
        Map<String, Object> claims = verifyJws(request);

        // Redis에 해당 accessToken 로그아웃 여부(저장 여부) 확인
        verifyLogout(jws, claims);

        // 다음 필터 호출
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

    private void verifyLogout(String jws, Map<String, Object> claims) {
        // 로그아웃 되어 있으면 String isLogout = "logout" (Redis에 해당 accessToken이 저장되어 있으므로)
        String isLogout = (String) redisTemplate.opsForValue().get(jws);
        // 로그아웃이 되어 있지 않은 경우(isLogout이 "logout"이 아닌 경우)
        if (ObjectUtils.isEmpty(isLogout)) {
            // SecurityContext에 Authentication 저장
            setAuthenticationToContext(claims);
        }
    }

    private void setAuthenticationToContext(Map<String, Object> claims) {
        String username = (String) claims.get("username");
        Integer memberId = (Integer) claims.get("memberId");
        List<GrantedAuthority> authorities = authorityUtils.createAuthorities((List) claims.get("roles"));

        Member member = new Member();
        member.setMemberId(Long.valueOf(memberId));
        member.setEmail(username);

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(member, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
