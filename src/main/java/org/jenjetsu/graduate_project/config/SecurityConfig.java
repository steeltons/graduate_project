package org.jenjetsu.graduate_project.config;

import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.jwt.configuration.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.*;
import org.springframework.web.cors.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationConfigurer jwtAuthenticationConfigurer;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider provider) throws Exception {
        http.apply(jwtAuthenticationConfigurer);
        http
            .authenticationProvider(provider)
            .cors(corsConfig -> corsConfig.configurationSource(source -> {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Arrays.asList("*"));
                configuration.setAllowedMethods(Arrays.asList("*"));
                configuration.setAllowedHeaders(Arrays.asList("*"));
                return configuration;
            }))
            .csrf(csrfConfig -> csrfConfig.disable())
            .authorizeHttpRequests(requestConfig ->
                requestConfig
                    .requestMatchers("/api/v1/users/registration").permitAll()
                    .requestMatchers("/v3/api-docs/**").permitAll()
                    .requestMatchers("/swagger-ui/**").permitAll()
                    .requestMatchers("/api/v1/users/registration").permitAll()
                    .anyRequest().authenticated()
            );

        return http.build();
    }

}
