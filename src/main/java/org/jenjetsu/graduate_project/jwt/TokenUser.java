package org.jenjetsu.graduate_project.jwt;

import lombok.Getter;
import org.jenjetsu.graduate_project.jwt.token.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class TokenUser extends User {

    @Getter
    private final Token token;

    public TokenUser(String username, String password,
                     Collection<? extends GrantedAuthority> authorities,
                     Token token) {
        super(username, password, authorities);
        this.token = token;
    }

    public TokenUser(String username, String password,
                     boolean enabled, boolean accountNonExpired,
                     boolean credentialsNonExpired, boolean accountNonLocked,
                     Collection<? extends GrantedAuthority> authorities,
                     Token token) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.token = token;
    }
}
