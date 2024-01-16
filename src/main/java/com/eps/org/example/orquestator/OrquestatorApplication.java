package com.eps.org.example.orquestator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.eps.org.example.orquestator.models")
public class OrquestatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestatorApplication.class, args);
	}

}
