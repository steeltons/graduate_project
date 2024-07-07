package org.jenjetsu.graduate_project.jwt.token.deserializer;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.jenjetsu.graduate_project.jwt.token.*;

import java.text.ParseException;
import java.util.UUID;
import java.util.function.Function;

@Slf4j
public class AccessTokenDeserializer implements Function<String, Token> {

    private final JWSVerifier jwsVerifier;
    private final JWSAlgorithm algorithm;

    public AccessTokenDeserializer(JWSVerifier jwsVerifier,
                                 JWSAlgorithm algorithm) {
        this.jwsVerifier = jwsVerifier;
        this.algorithm = algorithm;
    }

    @Override
    public Token apply(String s) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(s);
            if(signedJWT.verify(jwsVerifier)) {
                JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();
                return Token.builder()
                    .id(UUID.fromString(claimsSet.getJWTID()).toString())
                    .subject(claimsSet.getSubject())
                    .authorities(claimsSet.getStringListClaim("authorities"))
                    .role(claimsSet.getStringClaim("role"))
                    .createAt(claimsSet.getIssueTime().toInstant())
                    .expiredAt(claimsSet.getExpirationTime().toInstant())
                    .build();
            }
        } catch (ParseException | JOSEException e) {
            log.error("Error verifying access token. Error message: {}", e.getMessage());
        }
        return null;
    }
}
