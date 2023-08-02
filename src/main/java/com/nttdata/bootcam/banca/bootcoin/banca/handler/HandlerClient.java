package com.nttdata.bootcam.banca.bootcoin.banca.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.ClienBootCoinRepository;
import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientBootCoinDAO;


import reactor.core.publisher.Mono;

@Service
public class HandlerClient {

	@Autowired
	private ClienBootCoinRepository clienBootCoinRepository;
	
	public Mono<ServerResponse> saveClient(ServerRequest request) {
		Mono<ClientBootCoinDAO> clientMono = request.bodyToMono(ClientBootCoinDAO.class);
		Mono<String> saveResponse = clientMono.map(dto -> dto.getId() + ":" + dto.getTypeDocument()+":"+dto.getNumberDocument()+":"+dto.getNumberPhone()+":"+dto.getEmail() +":"+dto.getTypeClient());
		return ServerResponse.ok().body(saveResponse, String.class);
	}
	
	public Mono<ServerResponse> findClientById(ServerRequest request) {
		int clientId = Integer.valueOf(request.pathVariable("input"));
		Mono<ClientBootCoinDAO> clientStream = clienBootCoinRepository.findById(String.valueOf(clientId));
		return ServerResponse.ok().body(clientStream, ClientBootCoinDAO.class);
	}

}
