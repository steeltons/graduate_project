package org.jenjetsu.graduate_project.jwt.token.deserializer;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.extern.slf4j.Slf4j;
import org.jenjetsu.graduate_project.jwt.token.*;

import java.text.ParseException;
import java.util.UUID;
import java.util.function.Function;

@Slf4j
public class RefreshTokenDeserializer implements Function<String, Token> {

    private final JWEDecrypter jweDecrypter;

    public RefreshTokenDeserializer(JWEDecrypter jweDecrypter){
        this.jweDecrypter = jweDecrypter;
    }

    @Override
    public Token apply(String s) {
        try {
            EncryptedJWT encryptedJWT = EncryptedJWT.parse(s);
            encryptedJWT.decrypt(jweDecrypter);
            JWTClaimsSet claimsSet = encryptedJWT.getJWTClaimsSet();
            return Token.builder()
                .id(UUID.fromString(claimsSet.getJWTID()).toString())
                .subject(claimsSet.getSubject())
                .authorities(claimsSet.getStringListClaim("authorities"))
                .role(claimsSet.getStringClaim("role"))
                .createAt(claimsSet.getIssueTime().toInstant())
                .expiredAt(claimsSet.getExpirationTime().toInstant())
                .build();
        } catch (ParseException | JOSEException e) {
            log.error("Error verifying refresh token. Error message {}", e.getMessage());
        }
        return null;
    }
}
