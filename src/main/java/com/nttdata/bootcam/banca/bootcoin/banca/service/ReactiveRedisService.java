package com.nttdata.bootcam.banca.bootcoin.banca.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

import reactor.core.publisher.Mono;

@Service
public class ReactiveRedisService {

	private final ReactiveRedisTemplate<String, String> redisTemplate;

	@Autowired
	public ReactiveRedisService(ReactiveRedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public Mono<String> getValue(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public Mono<Boolean> setValue(String key, String value) {
		return redisTemplate.opsForValue().set(key, value);
	}
}
