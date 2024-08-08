package com.patel.sports.cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.patel.sports.cricket.repo")
public class CricketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CricketApplication.class, args);
    }

}
