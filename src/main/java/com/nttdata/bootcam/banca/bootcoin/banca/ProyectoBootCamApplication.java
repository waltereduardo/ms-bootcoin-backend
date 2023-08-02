package com.nttdata.bootcam.banca.bootcoin.banca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.nttdata.bootcam.banca.bootcoin.banca.repository.ClienBootCoinRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableCaching
@ComponentScan("com.nttdata.bootcam.banca.bootcoin.banca")
@EnableOpenApi
@OpenAPIDefinition(info = @Info(title = "REST  DEFINITION, ms-bootcoin-backend", version = "1.0.0", description = "Micro  service client management"))
public class ProyectoBootCamApplication implements CommandLineRunner {

	private final ClienBootCoinRepository clienBootCoinRepository;

	@Autowired
	public ProyectoBootCamApplication(ClienBootCoinRepository clienBootCoinRepository) {
		this.clienBootCoinRepository = clienBootCoinRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBootCamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		clienBootCoinRepository.findAll();
	}

}
