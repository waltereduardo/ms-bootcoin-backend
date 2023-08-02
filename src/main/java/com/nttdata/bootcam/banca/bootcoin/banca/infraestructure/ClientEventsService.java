package com.nttdata.bootcam.banca.bootcoin.banca.infraestructure;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.nttdata.bootcam.banca.bootcoin.banca.dto.event.BuyProductEvent;
import com.nttdata.bootcam.banca.bootcoin.banca.dto.event.ClientCatalogEvent;
import com.nttdata.bootcam.banca.bootcoin.banca.infraestructure.event.ClientCreatedEvent;
import com.nttdata.bootcam.banca.bootcoin.banca.infraestructure.event.ClientCreatedEventCompra;
import com.nttdata.bootcam.banca.bootcoin.banca.infraestructure.event.Event;
import com.nttdata.bootcam.banca.bootcoin.banca.infraestructure.event.EventType;
import com.nttdata.bootcam.banca.bootcoin.banca.mensajeria.repository.dao.SolicitudCatalogoDAO;
import com.nttdata.bootcam.banca.bootcoin.banca.service.ClientMessageService;
import com.nttdata.bootcam.banca.bootcoin.banca.util.Constantes;
import com.nttdata.bootcam.banca.bootcoin.banca.util.JsonUtil;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Value;

@Component
public class ClientEventsService {

	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	@Autowired
	private ClientMessageService clientMessageService;

	@Value("${catalog-request-topic}")
	private String topicCustomer;

	@Value("${order-request-topic}")
	private String topicCustomerOrder;

	@PostConstruct
	public void init() {
		System.out.println("topicCustomer: " + topicCustomer);
		System.out.println("topicCustomerOrder: " + topicCustomerOrder);
	}

	public void publishCatalogo(ClientCatalogEvent client) {
		ClientCreatedEvent selected = new ClientCreatedEvent();
		selected.setData(client);
		selected.setId(UUID.randomUUID().toString());
		selected.setType(EventType.CATALOGO);
		selected.setDate(new Date());
		selected.setTopico("catalog-request-topic");
		System.out.println("<<ClientCreatedEvent>>"+ selected.getData());
		System.out.println("<<ClientCreatedEvent>>"+ selected.getId());/////////736f97af-68f4-4f5a-8c54-ed075e25ef7a
		System.out.println("<<ClientCreatedEvent>>"+ selected.getType());/////////////CATALOGO
		System.out.println("<<ClientCreatedEvent>>"+ selected.getDate());
		System.out.println("<<ClientCreatedEvent>>"+ selected.getTopico());
		SolicitudCatalogoDAO scdao = new SolicitudCatalogoDAO();
		scdao.setDataMensaje(JsonUtil.convertirObjetoAJson(client));
		scdao.setDateMensaje(selected.getDate());
		scdao.setIdCliente(client.getId());
		scdao.setIdMensaje(selected.getId());
		scdao.setTopico(selected.getTopico());
		scdao.setTypeMensaje(selected.getType().name());
		scdao.setId(selected.getId());
		System.out.println("<<SolicitudCatalogoDAO>>"+ scdao.getDataMensaje());
		System.out.println("<<SolicitudCatalogoDAO>>"+ scdao.getDateMensaje());
		System.out.println("<<SolicitudCatalogoDAO>>"+ scdao.getIdCliente());
		System.out.println("<<SolicitudCatalogoDAO>>"+ scdao.getIdMensaje());/////////736f97af-68f4-4f5a-8c54-ed075e25ef7a
		System.out.println("<<SolicitudCatalogoDAO>>"+ scdao.getTopico());
		System.out.println("<<SolicitudCatalogoDAO>>"+ scdao.getTypeMensaje());////////////CATALOGO
		System.out.println("<<SolicitudCatalogoDAO>>"+ scdao.getId());////////736f97af-68f4-4f5a-8c54-ed075e25ef7a

//		clientMessageService.getIdMensaje(selected.getId())
//		clientMessageService.getIdMensaje(scdao.getTypeMensaje())
//				.filter(rdao -> rdao.getIdMensaje() != null && !rdao.getIdMensaje().isEmpty())
//				.switchIfEmpty(clientMessageService.saveMessageCatalog(scdao)).subscribe(result -> {
//					if (result != null) {
//						this.producer.send(topicCustomer, selected);
//						System.out.println("---PASANDO LA PUBLICACION---" + result);
//					} else {
//						System.out.println("---MENSAJE YA EXISTE EN EL TOPICO---");
//					}

		clientMessageService.getIdMensaje(scdao.getTypeMensaje())
	    .filter(solicitud ->  selected.getId().equals(solicitud.getIdMensaje()))
	    .collectList()
	    .flatMapMany(filteredSolicitudes -> {
	        if (filteredSolicitudes.isEmpty()) {
	            return clientMessageService.saveMessageCatalog(scdao).flux();
	        } else {
	            System.out.println("---MENSAJE YA EXISTE EN EL TOPICO---");
	            return Flux.empty(); 
	        }
	    })
	    .doOnNext(result -> {
	        if (result != null) {
	            this.producer.send(topicCustomer, selected);
	            System.out.println("---PASANDO LA PUBLICACION---" + result);
	        }
	    })
	    .subscribe();


//			System.out.println("ttttttttttt:" + rdao.getIdMensaje());
//			if (rdao.getIdMensaje().isEmpty()) {
//				clientMessageService.saveMessageCatalog(scdao).subscribe(result -> {
//					this.producer.send(topicCustomer, selected);
//					System.out.println("---PASANDO LA PUBLICACION---" + result);
//				}, error -> {
//					System.out.println("ERROR" + error.getMessage());
//				});
//
//			} else {
//				System.out.println("---MENSAJE YA EXISTE EN EL TOPICO---");
//			}
//				},error->
//
//	{
//					System.out.println("ERROR" + error.getMessage());
//				});

//		clientMessageService.saveMessageCatalog(scdao)
//		.subscribe(result->{
//			this.producer.send(topicCustomer, selected);
//			System.out.println("---PASANDO LA PUBLICACION---"  + result) ;
//		}, error->{
//			System.out.println("ERROR"  + error.getMessage()) ;
//		} );
//		

	}

	public void publishCompra(BuyProductEvent client) {
		ClientCreatedEventCompra saved = new ClientCreatedEventCompra();
		saved.setData(client);
		saved.setId(UUID.randomUUID().toString());
		saved.setType(EventType.CREATED);
		saved.setDate(new Date());
		saved.setTopico("order-request-topic");
		if (Constantes.MSG_COMPRA.equals(client.getMensaje()))
			this.producer.send(topicCustomerOrder, saved);
	}
}
