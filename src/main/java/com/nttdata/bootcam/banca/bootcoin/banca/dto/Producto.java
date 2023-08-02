package com.nttdata.bootcam.banca.bootcoin.banca.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Producto {

	@JsonProperty("identificador")
	private String id;
	private String typeProduct;
	private String detTypeProduct;
	private String descDetTypeProduct;

}
