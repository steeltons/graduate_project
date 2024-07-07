package org.jenjetsu.graduate_project.jwt.configuration;

import java.util.function.*;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import lombok.SneakyThrows;
import org.jenjetsu.graduate_project.jwt.token.*;
import org.jenjetsu.graduate_project.jwt.token.deserializer.*;
import org.jenjetsu.graduate_project.jwt.token.generator.*;
import org.jenjetsu.graduate_project.jwt.token.serializer.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessTokenConfigurer {

    private final JWSSigner jwsSigner;
    private final JWSVerifier jwsVerifier;
    private final JWSAlgorithm jwsAlgorithm;
    private final int accessTokenExistDurationMinutes;

    @SneakyThrows
    public AccessTokenConfigurer(@Value("${jwt.access-token-key}") String accessTokenKey,
                         @Value("${jwt.access-token-minutes}") String accessTokenMinutes,
                         @Value("${jwt.jws-algorithm}") String jwsAlgorithm) {
        this.jwsSigner= new MACSigner(OctetSequenceKey.parse(accessTokenKey));
        this.jwsVerifier = new MACVerifier(OctetSequenceKey.parse(accessTokenKey));
        this.jwsAlgorithm = JWSAlgorithm.parse(jwsAlgorithm);
        this.accessTokenExistDurationMinutes = Integer.parseInt(accessTokenMinutes);
    }

    @Bean
    public Function<Token, Token> accessTokenGenerator() {
        return new AccessTokenGenerator(accessTokenExistDurationMinutes);
    }

    @Bean
    public Function<Token, String> accessTokenSerializer() {
        return new AccessTokenSerializer(jwsSigner, jwsAlgorithm);
    }

    @Bean
    public Function<String, Token> accessTokenDeserializer() {
        return new AccessTokenDeserializer(jwsVerifier, jwsAlgorithm);
    }
}
