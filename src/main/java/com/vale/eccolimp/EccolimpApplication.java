package com.vale.eccolimp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.vale.eccolimp.repository")
public class EccolimpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EccolimpApplication.class, args);
    }
}
