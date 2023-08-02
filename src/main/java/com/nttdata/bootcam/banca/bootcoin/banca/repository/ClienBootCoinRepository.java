package com.nttdata.bootcam.banca.bootcoin.banca.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientBootCoinDAO;

public interface ClienBootCoinRepository extends ReactiveMongoRepository<ClientBootCoinDAO, String>{

}
