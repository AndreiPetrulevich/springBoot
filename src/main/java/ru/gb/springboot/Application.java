package ru.gb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // является базовым конфигуратором
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
