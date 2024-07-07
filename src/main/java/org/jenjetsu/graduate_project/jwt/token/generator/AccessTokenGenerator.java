package org.jenjetsu.graduate_project.jwt.token.generator;

import org.jenjetsu.graduate_project.jwt.token.*;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class AccessTokenGenerator implements Function<Token, Token> {

    private final Duration ACCESS_TOKEN_LIFE_TIME;

    public AccessTokenGenerator(Integer tokenLifeMinutesDuration) {
        this.ACCESS_TOKEN_LIFE_TIME = Duration.ofMinutes(tokenLifeMinutesDuration);
    }

    @Override
    public Token apply(Token token) {
        Instant now = Instant.now();
        var filteredAuthorities = token.getAuthorities().stream()
            .filter((authority) -> authority.startsWith("GRANT_"))
            .map((authority) -> authority.replace("GRANT_", ""))
            .toList();
        return Token.builder()
            .id(token.getId())
            .subject(token.getSubject())
            .authorities(filteredAuthorities)
            .role(token.getRole())
            .createAt(now)
            .expiredAt(now.plus(ACCESS_TOKEN_LIFE_TIME))
            .build();
    }

}
