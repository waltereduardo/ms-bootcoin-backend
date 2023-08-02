package com.nttdata.bootcam.banca.bootcoin.banca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClientProductResponse {

	private String idclient;
	private String idproduct;
	private String state;
	
}
