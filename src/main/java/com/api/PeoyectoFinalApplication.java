package com.api;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.repositories.UsuarioRepository;
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)

@SpringBootApplication
public class PeoyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeoyectoFinalApplication.class, args);
	}

}
