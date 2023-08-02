package com.nttdata.bootcam.banca.bootcoin.banca.infraestructure.event;

import com.nttdata.bootcam.banca.bootcoin.banca.dto.event.ClientCatalogEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientCreatedEvent extends Event<ClientCatalogEvent> {
	private String topico;
}
