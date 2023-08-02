package com.nttdata.bootcam.banca.bootcoin.banca.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.CreditClientDAO;

public interface CredicClientRepository extends ReactiveMongoRepository<CreditClientDAO, String> {

}
