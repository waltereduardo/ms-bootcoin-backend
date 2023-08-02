package com.nttdata.bootcam.banca.bootcoin.banca.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientDAO;

import reactor.core.publisher.Mono;

public interface ClientRepository extends ReactiveMongoRepository<ClientDAO, String>{
	
	Mono<ClientDAO> findByNumberDocument(String dni);
	
}
