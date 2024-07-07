package org.jenjetsu.graduate_project;

import org.jenjetsu.graduate_project.model.*;
import org.jenjetsu.graduate_project.service.impl.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraduateProjectApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(GraduateProjectApplication.class, args);
	    var registrationCodeService = context.getBean(RegistrationCodeService.class);
        var infoModel = UserCacheInfoModel.builder()
            .roleId(1L)
            .build();
        var code = registrationCodeService.putUserRegistration(infoModel);

        System.out.println("Код для регистрации: " + code.toString());
    }

}
