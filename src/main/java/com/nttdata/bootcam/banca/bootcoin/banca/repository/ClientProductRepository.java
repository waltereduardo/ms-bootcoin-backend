package com.nttdata.bootcam.banca.bootcoin.banca.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientProductDAO;

public interface ClientProductRepository extends ReactiveMongoRepository<ClientProductDAO,String>{

}
