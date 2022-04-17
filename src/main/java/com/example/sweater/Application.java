package com.example.sweater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        System.setProperty("spring.config.location",
//                "file:///D:/SpringProjects/sweater_secret_properties/application.properties");

        System.setProperty("spring.config.location",
                "file:///D:/SpringProjects/sweater_secret_properties/application-dev.properties");

        SpringApplication.run(Application.class, args);
    }

}
