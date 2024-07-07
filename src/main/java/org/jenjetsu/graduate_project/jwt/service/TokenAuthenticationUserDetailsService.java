package org.jenjetsu.graduate_project.jwt.service;

import lombok.AllArgsConstructor;
import org.jenjetsu.graduate_project.jwt.*;
import org.jenjetsu.graduate_project.jwt.token.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenAuthenticationUserDetailsService
        implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

//    private final DeactivatedTokenService deactivatedTokenService;

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken authenticationToken)
            throws UsernameNotFoundException {
        if(authenticationToken.getPrincipal() instanceof Token token) {
            return new TokenUser(token.getSubject(), "nopassword", true, true,
                    token.getExpiredAt().isAfter(Instant.now()), true,
                    token.getAuthorities().stream().map(SimpleGrantedAuthority::new).toList(),
                    token);
        }
        throw new UsernameNotFoundException("Principal must be of type Token");
    }
}
