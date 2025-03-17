package com.example.app_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class AppTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTestApplication.class, args);
		System.out.println("Started...");
	}

}
