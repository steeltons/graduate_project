package org.jenjetsu.graduate_project.config;

import java.util.*;

import org.jenjetsu.graduate_project.client.model.*;
import org.jenjetsu.graduate_project.entity.*;
import org.modelmapper.*;
import org.modelmapper.convention.*;
import org.springframework.context.annotation.*;

import static org.modelmapper.config.Configuration.AccessLevel.*;

@Configuration
public class ModelMapperConfiguration {

    private Converter<UUID, UUID> uuidConverter = ctx -> UUID.fromString(ctx.getSource()
        .toString());

    private Converter<Collection<FWI>, String> fwiNamesConverter = ctx -> ctx.getSource()
        .stream()
        .map(FWI::getName)
        .reduce("", (acc, value) -> acc + ", " + value);

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setDeepCopyEnabled(true)
            .setFieldAccessLevel(PRIVATE)
            .setMatchingStrategy(MatchingStrategies.LOOSE);

        modelMapper.addConverter(uuidConverter, UUID.class, UUID.class);
        modelMapper.createTypeMap(FFWI.class, FFWIResponseDto.class)
            .addMappings(mapper -> mapper.using(fwiNamesConverter)
                .map(FFWI::getFwiSet, FFWIResponseDto::setFwis));

        return modelMapper;
    }

}
