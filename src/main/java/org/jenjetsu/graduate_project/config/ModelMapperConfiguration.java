package org.jenjetsu.graduate_project.config;

import java.util.*;

import org.modelmapper.*;
import org.modelmapper.convention.*;
import org.springframework.context.annotation.*;

import static org.modelmapper.config.Configuration.AccessLevel.*;

@Configuration
public class ModelMapperConfiguration {

    private Converter<UUID, UUID> uuidConverter = ctx -> UUID.fromString(ctx.getSource().toString());

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setDeepCopyEnabled(true)
            .setFieldAccessLevel(PRIVATE)
            .setMatchingStrategy(MatchingStrategies.LOOSE);

        modelMapper.addConverter(uuidConverter, UUID.class, UUID.class);
        return modelMapper;
    }

}
