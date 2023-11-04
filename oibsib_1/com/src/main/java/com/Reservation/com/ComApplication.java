package com.Reservation.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.*"})

public class ComApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComApplication.class, args);
	}

}
