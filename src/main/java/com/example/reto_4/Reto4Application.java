package com.example.reto_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"Controller", "Model", "Repository", "Services"})
@EntityScan("Model")
@EnableJpaRepositories("Repository")

public class Reto4Application {

    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }

}
