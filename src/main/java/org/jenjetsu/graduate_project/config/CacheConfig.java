package org.jenjetsu.graduate_project.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.*;
import org.springframework.cache.annotation.*;
import org.springframework.cache.concurrent.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${app.cache.name}")
    private String appCacheName;

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(appCacheName);
    }

}
