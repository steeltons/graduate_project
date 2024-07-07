package org.jenjetsu.graduate_project.service.impl;

import java.time.*;
import java.util.*;

import lombok.*;
import org.jenjetsu.graduate_project.exception.*;
import org.jenjetsu.graduate_project.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class RegistrationCodeService {

    private final CacheManager cacheManager;

    private final Clock appClock;

    @Value("${app.cache.name}")
    private String appCacheName;

    @Value("${app.cache.key.registration-code}")
    private String registrationCodeKey;

    public UUID putUserRegistration(UserCacheInfoModel infoModel) {
        var cache = cacheManager.getCache(appCacheName);

        if (cache == null) {
            throw new IllegalStateException(format(
                "Кеш с назвнием %s не существует",
                appCacheName));
        }

        if (infoModel.getRegistrationCode() == null) {
            infoModel.setRegistrationCode(UUID.randomUUID());
        }
        var code = infoModel.getRegistrationCode();

        infoModel.setExpiredAt(ZonedDateTime.now(appClock).plusHours(96L));
        cache.put(registrationCodeKey + ":" + code.toString(), infoModel);

        return code;
    }

    public UserCacheInfoModel getUserRegistrationInfo(UUID registrationCode) {
        var cache = cacheManager.getCache(appCacheName);

        if (cache == null) {
            throw new IllegalStateException(format(
                "Кеш с назвнием %s не существует",
                appCacheName));
        }

        var info = cache.get(
            registrationCodeKey + ":" + registrationCode.toString(),
            UserCacheInfoModel.class);

        if (isCodeExpired(info)) {
            throw new ApiException("Код регистрации истёк", HttpStatus.NOT_FOUND);
        }

        return info;
    }

    public void clearExpiredCodes() {

    }

    public void evictCode(UUID registrationCode) {
        var cache = cacheManager.getCache(appCacheName);

        if (cache == null) {
            throw new IllegalStateException(format(
                "Кеш с назвнием %s не существует",
                appCacheName));
        }

        cache.evict(registrationCodeKey + ":" + registrationCode.toString());
    }

    private boolean isCodeExpired(UserCacheInfoModel infoModel) {
        var currentDateTime = ZonedDateTime.now(appClock);

        return infoModel == null || currentDateTime.isAfter(infoModel.getExpiredAt());
    }

}
