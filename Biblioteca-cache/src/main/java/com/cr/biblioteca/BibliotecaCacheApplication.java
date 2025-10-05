package com.cr.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // ← AÑADE ESTA LÍNEA
public class BibliotecaCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(BibliotecaCacheApplication.class, args);
    }
}