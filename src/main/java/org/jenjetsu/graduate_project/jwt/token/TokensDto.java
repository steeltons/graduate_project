package org.jenjetsu.graduate_project.jwt.token;

public record TokensDto(String refreshToken, String refreshTokenExpirationTime,
                        String accessToken, String accessTokenExpirationTime) {
}
