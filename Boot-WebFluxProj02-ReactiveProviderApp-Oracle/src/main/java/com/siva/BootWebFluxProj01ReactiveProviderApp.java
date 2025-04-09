package com.siva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
//@EnableR2dbcRepositories(basePackages = "com.siva.webrepository")
//@EntityScan(basePackages = "com.siva.model")
public class BootWebFluxProj01ReactiveProviderApp {

	public static void main(String[] args) {
		SpringApplication.run(BootWebFluxProj01ReactiveProviderApp.class, args);
	}

}
