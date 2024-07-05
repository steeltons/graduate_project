package org.jenjetsu.graduate_project.model;

import java.util.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationModel {

    private String login;

    private String email;

    private String rawPassword;

    private UUID registrationCode;

}
