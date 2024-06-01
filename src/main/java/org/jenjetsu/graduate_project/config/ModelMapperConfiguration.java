package org.jenjetsu.graduate_project.config;

import org.modelmapper.*;
import org.modelmapper.convention.*;
import org.springframework.context.annotation.*;

import static org.modelmapper.config.Configuration.AccessLevel.*;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setDeepCopyEnabled(true)
            .setFieldAccessLevel(PRIVATE)
            .setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper;
    }

}
