package com.nttdata.bootcam.banca.bootcoin.banca;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientBootCoinDAO;
import com.nttdata.bootcam.banca.bootcoin.banca.util.ClientBootCoinDAOSerializer;
import java.time.Duration;

import static org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class CacheConfig {

//	@Bean
//	public RedisCacheConfiguration cacheConfiguration() {
//		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(60)).disableCachingNullValues()
//				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//	}

//	@Bean
//	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//		return (builder) -> builder
//				.withCacheConfiguration("clientCache",
//						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
//				.withCacheConfiguration("customerCache",
//						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
//	}

	@Bean
	public RedisSerializer<ClientBootCoinDAO> clientBootCoinDAOSerializer() {
		return new ClientBootCoinDAOSerializer();
	}

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(60)).disableCachingNullValues()
				.serializeValuesWith(SerializationPair.fromSerializer(clientBootCoinDAOSerializer()));
	}

}
