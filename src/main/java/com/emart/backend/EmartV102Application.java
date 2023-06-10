package com.emart.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.emart.backend.*")
@EntityScan(basePackages="com.emart.backend.*")
@EnableJpaRepositories(basePackages="com.emart.backend.*")
public class EmartV102Application {

	public static void main(String[] args) {
		SpringApplication.run(EmartV102Application.class, args);
		System.out.println("DONE");
	}

}
