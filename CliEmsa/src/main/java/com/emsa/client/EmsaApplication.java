package com.emsa.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.emsa.client.repository")
public class EmsaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EmsaApplication.class);
        app.setAdditionalProfiles("debug");
        app.run(args);
	}

}
