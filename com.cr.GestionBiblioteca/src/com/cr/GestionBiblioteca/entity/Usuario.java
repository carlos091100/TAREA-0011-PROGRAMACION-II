package com.cr.GestionBiblioteca.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private String carnet;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.librosPrestados = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public List<Libro> getLibrosPrestados() {
        return new ArrayList<>(librosPrestados); // copia defensiva
    }

    public void registrarPrestamo(Libro libro) {
        librosPrestados.add(libro);
    }

    public void registrarDevolucion(Libro libro) {
        librosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " (Carnet: " + carnet + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(carnet, usuario.carnet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carnet);
    }
}