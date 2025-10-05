package com.cr.biblioteca.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cr.biblioteca.entity.Libro;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibroService {

    private static final Logger log = LoggerFactory.getLogger(LibroService.class);

    private final Map<Long, Libro> db = new HashMap<>();

    public LibroService() {
        db.put(1L, new Libro(1L, "Cien años de soledad", "Gabriel García Márquez", 1967));
        db.put(2L, new Libro(2L, "Don Quijote", "Miguel de Cervantes", 1605));
        db.put(3L, new Libro(3L, "1984", "George Orwell", 1949));
    }

    @Cacheable(value = "libros", key = "#id")
    public Libro obtenerLibroPorId(Long id) {
        log.info("🔍 Consultando libro con ID {} desde la base de datos...", id);
        try {
            Thread.sleep(1000); // Simula retraso de BD
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return db.get(id);
    }
}