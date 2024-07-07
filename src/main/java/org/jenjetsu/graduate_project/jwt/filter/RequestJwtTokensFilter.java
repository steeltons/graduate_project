package org.jenjetsu.graduate_project.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;
import org.jenjetsu.graduate_project.jwt.token.*;
import org.jenjetsu.graduate_project.jwt.token.generator.*;
import org.jenjetsu.graduate_project.jwt.token.serializer.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class RequestJwtTokensFilter extends OncePerRequestFilter {

    private final RequestMatcher matcher = new AntPathRequestMatcher("/api/v1/login", HttpMethod.POST.name());
    private final SecurityContextRepository securityContextRep = new RequestAttributeSecurityContextRepository();
    private final ObjectMapper objectMapper;
    private final RefreshTokenGenerator refreshTokenGenerator;
    private final AccessTokenGenerator accessTokenGenerator;
    private final RefreshTokenSerializer refreshTokenStringSerializer;
    private final AccessTokenSerializer accessTokenStringSerializer;

    private final AuthenticationManager manager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (matcher.matches(request)) {
            var username = request.getParameter("username");
            var password = request.getParameter("password");
            var test = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
            var auth = manager.authenticate(test);
            if(!auth.isAuthenticated()) {
                throw new AccessDeniedException("Error authentication");
            }
            Token refreshToken = refreshTokenGenerator.apply(auth);
            Token accessToken = accessTokenGenerator.apply(refreshToken);
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            objectMapper.writeValue(response.getWriter(),
                    new TokensDto(refreshTokenStringSerializer.apply(refreshToken), refreshToken.getExpiredAt().toString(),
                            accessTokenStringSerializer.apply(accessToken), accessToken.getExpiredAt().toString()));
            return;
        }
        filterChain.doFilter(request, response);
    }
}
