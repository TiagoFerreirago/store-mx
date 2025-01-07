package com.mx.shopping_cart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTestRunner implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("testKey", "Hello, Redis!");
        String value = redisTemplate.opsForValue().get("testKey");
        System.out.println("Value from Redis: " + value);
    }
}