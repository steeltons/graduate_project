package org.jenjetsu.graduate_project.config;

import java.time.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class ClockConfig {

    @Value("${app.zone-date-time}")
    private String appZoneDateTime;

    @Bean
    public Clock appClock() {
        return Clock.system(ZoneId.of(appZoneDateTime));
    }
}
