package com.nttdata.bootcam.banca.bootcoin.banca.repository.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Document("cliente-bootcoin")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientBootCoinDAO {
	
	@Id
	private String id;
	private String typeDocument;
	private String numberDocument;
	private String numberPhone;
	private String email;
	private String typeClient;
}
