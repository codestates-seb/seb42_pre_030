package com.vivarepublica.vivastackoverflow.auth.service;

import com.vivarepublica.vivastackoverflow.auth.dto.LogoutDto;
import com.vivarepublica.vivastackoverflow.auth.jwt.JwtTokenizer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Service
@Transactional
public class LogoutService {
    private final JwtTokenizer jwtTokenizer;
    private final RedisTemplate<String, Object> redisTemplate;

    public void logout(LogoutDto logoutDto) {
        // 앞의 Bearer를 제거한 순수한 AccessToken
        String jws = logoutDto.getAccessToken().replace("Bearer ", "");
        // 검증을 위한 base64EncodedSecretKey
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        // 토큰 유효성 검증 및 claims에서 해당 User email 추출
        Jws<Claims> claims = jwtTokenizer.getClaims(jws, base64EncodedSecretKey);
        Map<String, Object> body = claims.getBody();
        String username = (String) body.get("username");

        // Redis에서 해당 User email로 저장된 Refresh Token이 있는지 여부를 확인 후에 있을 경우 삭제를 한다.
        if (redisTemplate.opsForValue().get(String.format("RT:%s", username)) != null) {
            redisTemplate.delete(String.format("RT:%s", username));
        }

        // 해당 AccessToken의 유효시간
        Long expiration = claims.getBody().getExpiration().getTime() / 1000;
        // 해당 AccessToken을 BlackList로 Redis에 저장
        redisTemplate.opsForValue().set(jws, "logout", expiration, TimeUnit.MILLISECONDS);
    }
}
