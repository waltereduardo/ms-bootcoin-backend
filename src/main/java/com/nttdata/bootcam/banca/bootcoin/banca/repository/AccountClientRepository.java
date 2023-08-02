package com.nttdata.bootcam.banca.bootcoin.banca.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.AccountClientDAO;

import reactor.core.publisher.Mono;


public interface AccountClientRepository extends ReactiveMongoRepository<AccountClientDAO, String> {
	  Mono<AccountClientDAO> findByIdClient(String idCliente);
}
