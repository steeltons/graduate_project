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

    private Converter<UUID, UUID> uuidConverter = ctx -> Optional.ofNullable(ctx.getSource())
        .orElse(null);

    private Converter<FFWI, UUID> ffwiToIdConverter = ctx -> Optional.ofNullable(ctx.getSource())
        .map(FFWI::getId)
        .orElse(null);

    private Converter<Collection<FWI>, String> fwiNamesConverter = ctx -> {
        var fwis = ctx.getSource().stream().map(FWI::getName).toList();
        var names = String.join(",", fwis);

        return names;
    };

    private Converter<String, WeatherData> ffwiWeatherDataCreateConverter = ctx -> WeatherData.builder()
        .id(ctx.getSource() != null ? UUID.fromString(ctx.getSource()) : null)
        .build();

    private Converter<FFWI, String> ffwiToFwiNameConverter = ctx -> Optional.ofNullable(ctx.getSource())
        .map(FFWI::getName).orElse("");

    private Converter<FireDanger, String> fitreDangertoFwiNameConverter = ctx -> Optional.ofNullable(
            ctx.getSource())
        .map(FireDanger::getName)
        .orElse("");

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setDeepCopyEnabled(true)
            .setFieldAccessLevel(PRIVATE)
            .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.addConverter(uuidConverter, UUID.class, UUID.class);

        modelMapper.createTypeMap(FFWI.class, FFWIResponseDto.class)
            .addMappings(mapper -> mapper.using(fwiNamesConverter)
                .map(FFWI::getFwiSet, FFWIResponseDto::setFwis));
        modelMapper.createTypeMap(FFWIWeatherParamDto.class, FFWIParameter.class)
            .addMappings(mapper -> mapper.using(ffwiWeatherDataCreateConverter)
                .map(FFWIWeatherParamDto::getWeatherDataId, FFWIParameter::setWeatherData));
        modelMapper.createTypeMap(FWI.class, FWIResponseDto.class)
            .addMappings(mapper -> mapper.using(ffwiToFwiNameConverter)
                .map(FWI::getFfwi, FWIResponseDto::setFfwiName))
            .addMappings(mapper -> mapper.using(fitreDangertoFwiNameConverter)
                .map(FWI::getFireDanger, FWIResponseDto::setFireDangerName));

        modelMapper.createTypeMap(PrecipitationTable.class, PrecipitationRecordResponseDto.class)
            .addMappings(mapping -> mapping.using(ffwiToFwiNameConverter)
                .map(PrecipitationTable::getFfwi, PrecipitationRecordResponseDto::setFfwiName))
            .addMappings(mapper -> mapper.using(ffwiToIdConverter)
                .map(PrecipitationTable::getFfwi, PrecipitationRecordResponseDto::setFfwId));

        return modelMapper;
    }

}
