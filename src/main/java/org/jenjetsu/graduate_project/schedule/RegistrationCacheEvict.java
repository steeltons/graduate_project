//package org.jenjetsu.graduate_project.schedule;
//
//import lombok.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.*;
//import org.springframework.scheduling.annotation.*;
//import org.springframework.stereotype.*;
//
//import static java.lang.String.format;
//
//@Component
//@RequiredArgsConstructor
//public class RegistrationCacheEvict {
//
//    private final CacheManager cacheManager;
//
//    @Value("${app.cache.name}")
//    private String appCacheName;
//
//    @Value("${app.cache.key.registration-code}")
//    private final String registrationCodeKey;
//
//    @Scheduled(cron = "#")
//    public void evictCacheManager() {
//        var cache = cacheManager.getCache(appCacheName);
//
//        if (cache == null) {
//            throw new IllegalStateException(format(
//                "Кеш с назвнием %s не существует",
//                appCacheName));
//        }
//
//        cache.evict(registrationCodeKey);
//    }
//
//}
