package com.example.tospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ToSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToSpringBootApplication.class, args);
    }

}
