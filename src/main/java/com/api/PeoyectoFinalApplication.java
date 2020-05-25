package com.api;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.config.FileStorageProperties;

 
@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class PeoyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeoyectoFinalApplication.class, args);
	}

}
