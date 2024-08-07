package org.jenjetsu.graduate_project.jwt.token.generator;

import org.jenjetsu.graduate_project.jwt.token.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class RefreshTokenGenerator implements Function<Authentication, Token> {

    private final Duration REFRESH_TOKEN_LIFE_TIME;

    public RefreshTokenGenerator(Integer tokenLifeDaysDuration) {
        this.REFRESH_TOKEN_LIFE_TIME = Duration.ofDays(tokenLifeDaysDuration);
    }

    @Override
    public Token apply(Authentication auth) {
        List<String> authorities = new ArrayList<>();
        authorities.add("JWT_REFRESH");
        authorities.add("JWT_LOGOUT");
        var userRole = auth.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .filter(role -> role.startsWith("ROLE_"))
            .map(role -> role.replace("ROLE_", ""))
            .findFirst().get();
        auth.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .map((authority) -> "GRANT_" + authority)
            .forEach(authorities::add);
        Instant now = Instant.now();
        return Token.builder()
            .id(UUID.randomUUID().toString())
            .subject(auth.getName())
            .role(userRole)
            .authorities(authorities)
            .createAt(now)
            .expiredAt(now.plus(REFRESH_TOKEN_LIFE_TIME))
            .build();
    }

}
