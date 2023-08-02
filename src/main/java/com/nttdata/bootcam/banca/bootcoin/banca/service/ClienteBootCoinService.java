package com.nttdata.bootcam.banca.bootcoin.banca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcam.banca.bootcoin.banca.dto.ClientBootCoin;
import com.nttdata.bootcam.banca.bootcoin.banca.repository.ClienBootCoinRepository;
import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientBootCoinDAO;

import reactor.core.publisher.Mono;

@Service
public class ClienteBootCoinService {

	private final ClienBootCoinRepository clienBootCoinRepository;

	@Autowired
	public ClienteBootCoinService(ClienBootCoinRepository clienBootCoinRepository) {
		this.clienBootCoinRepository = clienBootCoinRepository;
	}

	public Mono<ClientBootCoinDAO> registrarCliente(ClientBootCoinDAO clientBootCoinDAO) {
		return clienBootCoinRepository.save(clientBootCoinDAO);
	}

	@Cacheable(value = "clientCache")
	public ClientBootCoinDAO findClientById(String id) {
		ObjectMapper objectMapper = new ObjectMapper();
		return clienBootCoinRepository.findById(id).blockOptional().get();

	}


}
