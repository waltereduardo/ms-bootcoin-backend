package com.nttdata.bootcam.banca.bootcoin.banca;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientBootCoinDAO;

@Configuration
public class RedisCacheConfig {

	@Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> {
            builder
                .withCacheConfiguration("clientCache",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<>(ClientBootCoinDAO.class)))
                );
        };
    }
}

