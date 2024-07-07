package org.jenjetsu.graduate_project.config;

import java.util.*;

import org.jenjetsu.graduate_project.service.impl.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

@Configuration
public class AuthenticationConfig {

    @Bean
    public AuthenticationManager authenticationManager(List<AuthenticationProvider> providers) {
        var manager = new ProviderManager(providers);

        return manager;
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
