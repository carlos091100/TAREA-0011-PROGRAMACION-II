package com.cr.biblioteca.entity;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private int año;

    public Libro() {}

    public Libro(Long id, String titulo, String autor, int año) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAño() { return año; }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "', año=" + año + "}";
    }
}