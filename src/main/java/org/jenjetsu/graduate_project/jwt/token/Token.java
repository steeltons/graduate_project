package org.jenjetsu.graduate_project.jwt.token;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private String id;
    private String subject;
    private String role;
    private List<String> authorities;
    private Instant createAt;
    private Instant expiredAt;
}
