package com.github.prashantcsutar.javatutorials.cacheexample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EhCacheExampleController {

    @GetMapping("api/v1/users/{userId}")
    @Cacheable(cacheNames = "simpleCache", key = "#userId")
    public Map<String, Object> getUserInfo(@PathVariable(name = "userId") long userId) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("token", System.currentTimeMillis());

        return userInfo;
    }
}
