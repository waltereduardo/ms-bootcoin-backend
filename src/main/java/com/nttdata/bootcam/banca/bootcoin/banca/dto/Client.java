package com.nttdata.bootcam.banca.bootcoin.banca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Client extends ClientResponse{
	
	@JsonProperty("identificador")
	private String id;
	private ClientResponse clientResponse;
//	private String typeDocument;
//	private String numberDocument;
//	private String typeClient;
//	private String nameAll;
	

	
}
