package org.jenjetsu.graduate_project.service.impl;

import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.entity.User;
import org.jenjetsu.graduate_project.model.*;
import org.jenjetsu.graduate_project.repository.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import static java.lang.String.format;

@Service
public class UserServiceImpl extends SimpleJpaService<User, Long>
    implements UserService, UserDetailsService {

    private final UserRepository userRep;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RegistrationCodeService codeService;

    public UserServiceImpl(UserRepository userRep, PasswordEncoder passwordEncoder) {
        super(User.class, userRep);
        this.userRep = userRep;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createEntity(User raw) {
        var encodedPassword = passwordEncoder.encode(raw.getPassword());
        raw.setPassword(encodedPassword);

        return super.createEntity(raw);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRep.findByLogin(username);

        if (user == null) {
            throw new BadCredentialsException(format(
                "Пользователь с логином/почтой %s и паролем не найден",
                username));
        }

        var role = user.getRole();
        var authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getLogin())
            .password(user.getPassword())
            .authorities(authorities)
            .disabled(false)
            .accountLocked(false)
            .build();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User registrateUser(UserRegistrationModel registrationModel) {
        var info = codeService.getUserRegistrationInfo(registrationModel.getRegistrationCode());

        var rawUser = User.builder()
            .login(registrationModel.getLogin())
            .email(registrationModel.getEmail())
            .password(registrationModel.getRawPassword())
            .role(Role.builder().id(info.getRoleId()).build())
            .build();

        var result = this.createEntity(rawUser);
        codeService.evictCode(info.getRegistrationCode());

        return result;
    }

}
