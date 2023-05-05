package com.example.arbeitnowapiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ArbeitnowApiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArbeitnowApiAppApplication.class, args);
    }

}
