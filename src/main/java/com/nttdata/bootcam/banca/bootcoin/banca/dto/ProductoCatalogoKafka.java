package com.nttdata.bootcam.banca.bootcoin.banca.dto;

//import java.io.Serializable;

import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class ProductoCatalogoKafka{
	/**
	 * 
	 */

	private String id;
	private String idTypeProduct;
	private String descCortaProduct;
	private String cantidad;
	private String precioUnitario;
	
	
	
}
