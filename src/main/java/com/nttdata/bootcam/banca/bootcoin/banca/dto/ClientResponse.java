package com.nttdata.bootcam.banca.bootcoin.banca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClientResponse {
	
	
	private String typeDocument;
	private String numberDocument;
	private String typeClient;
	private String nameAll;

	
}
