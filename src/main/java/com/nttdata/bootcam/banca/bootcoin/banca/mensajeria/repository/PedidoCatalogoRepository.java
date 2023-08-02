package com.nttdata.bootcam.banca.bootcoin.banca.mensajeria.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcam.banca.bootcoin.banca.mensajeria.repository.dao.SolicitudCatalogoDAO;

import reactor.core.publisher.Flux;



public interface PedidoCatalogoRepository extends ReactiveMongoRepository<SolicitudCatalogoDAO, String> {
	Flux<SolicitudCatalogoDAO> findByTypeMensaje(String typeMensaje);
}



