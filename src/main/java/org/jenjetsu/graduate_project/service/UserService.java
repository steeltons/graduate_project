package org.jenjetsu.graduate_project.service;

import java.util.*;

import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.model.*;

public interface UserService extends CrudService<User, Long> {

    public User registrateUser(UserRegistrationModel registrationModel);

}
