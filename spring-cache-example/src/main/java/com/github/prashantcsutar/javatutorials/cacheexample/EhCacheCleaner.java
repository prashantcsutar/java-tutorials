package com.github.prashantcsutar.javatutorials.cacheexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class EhCacheCleaner {
    @Autowired
    private CacheManager cacheManager;

    @Scheduled(fixedRate = 12000)
    public void evictSimpleCache() {
        log.info("Evicting simple cache");
        cacheManager.getCache("simpleCache").clear();
    }
}
