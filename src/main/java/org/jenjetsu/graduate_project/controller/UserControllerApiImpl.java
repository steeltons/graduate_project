package org.jenjetsu.graduate_project.controller;

import lombok.*;
import org.jenjetsu.graduate_project.client.api.*;
import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.model.*;
import org.jenjetsu.graduate_project.service.*;
import org.modelmapper.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserControllerApiImpl implements UserControllerApi {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<Void> loginUser(UserLoginDto userLoginDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> registrateUser(UserCreateDto userCreateDto) {
        var registrationModel = modelMapper.map(userCreateDto, UserRegistrationModel.class);

        userService.registrateUser(registrationModel);

        return ResponseEntity.ok(null);
    }

}
