package org.jenjetsu.graduate_project.config;

import java.util.*;

import org.jenjetsu.graduate_project.service.*;
import org.jenjetsu.graduate_project.service.impl.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.web.cors.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
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
//                    .requestMatchers("/api/v1/users/registration").permitAll()
//                    .requestMatchers("/v3/api-docs/**").permitAll()
//                    .requestMatchers("/swagger-ui/**").permitAll()
//                    .anyRequest().authenticated()
                    .anyRequest().permitAll()
            )
            .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
        UserServiceImpl userService,
        PasswordEncoder passwordEncoder
    ) {
        var daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(userService);
        daoProvider.setPasswordEncoder(passwordEncoder);

        return daoProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
