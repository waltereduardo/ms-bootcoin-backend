package com.nttdata.bootcam.banca.bootcoin.banca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountClientResponse {

	@JsonProperty("identificador")
	private String idClient;
	private String idProduct;
	private String typeProduct;
}
