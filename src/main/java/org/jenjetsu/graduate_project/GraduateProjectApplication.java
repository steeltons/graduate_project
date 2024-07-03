package org.jenjetsu.graduate_project;

import java.math.*;
import java.util.*;

import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.entity.*;
import org.jenjetsu.graduate_project.service.*;
import org.jenjetsu.graduate_project.service.impl.*;
import org.modelmapper.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraduateProjectApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(GraduateProjectApplication.class, args);
        var ffwiService = context.getBean(FFWIServiceImpl.class);

        var ffwis = ffwiService.findAllFetchSubEntities();
        var modelMapper = context.getBean(ModelMapper.class);

        int ii = 43;
	}

    private static FFWIResponseDto mapToDto(FFWI ffwi, ModelMapper modelMapper) {
        List<String> fwiNames = ffwi.getFwiSet().stream().map(FWI::getName).toList();
        String fwiNamesString = String.join(", ", fwiNames);

        var dto = modelMapper.map(ffwi, FFWIResponseDto.class);
        dto.setFwis(fwiNamesString);

        return dto;
    }

}
