package com.nttdata.bootcam.banca.bootcoin.banca.util;

import java.io.IOException;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcam.banca.bootcoin.banca.repository.dao.ClientBootCoinDAO;

public class ClientBootCoinDAOSerializer implements RedisSerializer<ClientBootCoinDAO> {

	private final ObjectMapper objectMapper;

	public ClientBootCoinDAOSerializer() {
		this.objectMapper = new ObjectMapper();
	}

	@Override
	public byte[] serialize(ClientBootCoinDAO clientBootCoinDAO) throws SerializationException {
		try {
			return objectMapper.writeValueAsBytes(clientBootCoinDAO);
		} catch (JsonProcessingException e) {
			throw new SerializationException("Error al serializar ClientBootCoinDAO", e);
		}
	}

	@Override
	public ClientBootCoinDAO deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		try {
			return objectMapper.readValue(bytes, ClientBootCoinDAO.class);
		} catch (JsonProcessingException e) {
			throw new org.springframework.data.redis.serializer.SerializationException(
					"Error al deserializar ClientBootCoinDAO", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
