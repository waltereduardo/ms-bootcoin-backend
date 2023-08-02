package com.nttdata.bootcam.banca.bootcoin.banca.rest;

import javax.sql.rowset.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcam.banca.bootcoin.banca.dto.ClientBootCoin;
import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientBootCoinDAO;
import com.nttdata.bootcam.banca.bootcoin.banca.service.ClienteBootCoinService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/apicoin")
public class ClienteMonederoController {

	@Autowired
	private ClienteBootCoinService clienteBootCoinService;

	@PostMapping
	public Mono<ClientBootCoin> saveCliente(@RequestBody ClientBootCoin clientBootCoin) {
		return clienteBootCoinService.registrarCliente(this.fromClientBootCoinToClientBootCoinDAO(clientBootCoin))
				.map(this::fromClientBootCoinDAOToClientBootCoin);

	}

	@GetMapping("/{id}")
	public ClientBootCoinDAO findClientById(@PathVariable String id) {

		return	clienteBootCoinService.findClientById(id);
 
	}

	private ClientBootCoinDAO fromClientBootCoinToClientBootCoinDAO(ClientBootCoin clientBootCoin) {
		ClientBootCoinDAO cdao = new ClientBootCoinDAO();
		cdao.setEmail(clientBootCoin.getEmail());
		cdao.setId(clientBootCoin.getId());
		cdao.setNumberDocument(clientBootCoin.getNumberDocument());
		cdao.setNumberPhone(clientBootCoin.getNumberPhone());
		cdao.setTypeClient(clientBootCoin.getTypeClient());
		cdao.setTypeDocument(clientBootCoin.getTypeDocument());
		return cdao;
	}

	private ClientBootCoin fromClientBootCoinDAOToClientBootCoin(ClientBootCoinDAO clientBootCoin) {
		ClientBootCoin cdao = new ClientBootCoin();
		cdao.setEmail(clientBootCoin.getEmail());
		cdao.setId(clientBootCoin.getId());
		cdao.setNumberDocument(clientBootCoin.getNumberDocument());
		cdao.setNumberPhone(clientBootCoin.getNumberPhone());
		cdao.setTypeClient(clientBootCoin.getTypeClient());
		cdao.setTypeDocument(clientBootCoin.getTypeDocument());
		return cdao;
	}

}
