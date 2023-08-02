package com.nttdata.bootcam.banca.bootcoin.banca.infraestructure.event;

import com.nttdata.bootcam.banca.bootcoin.banca.dto.event.BuyProductEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientCreatedEventCompra extends Event<BuyProductEvent>{
	private String topico;
}
