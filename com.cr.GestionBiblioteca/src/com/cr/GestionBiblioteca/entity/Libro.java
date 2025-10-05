package com.cr.GestionBiblioteca.entity;

import java.util.Objects;
import com.cr.GestionBiblioteca.interfaz.Gestionable;

public class Libro implements Gestionable {
    private String titulo;
    private String autor;
    private int año;
    private String estado; // "disponible" o "prestado"
    private Usuario usuarioPrestamo;

    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.estado = "disponible";
        this.usuarioPrestamo = null;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAño() {
        return año;
    }

    public String getEstado() {
        return estado;
    }

    public Usuario getUsuarioPrestamo() {
        return usuarioPrestamo;
    }

    @Override
    public void prestar(Usuario usuario) {
        if (!"disponible".equals(estado)) {
            throw new IllegalStateException("El libro ya está prestado.");
        }
        this.estado = "prestado";
        this.usuarioPrestamo = usuario;
        usuario.registrarPrestamo(this);
    }

    @Override
    public void devolver() {
        if (!"prestado".equals(estado)) {
            throw new IllegalStateException("El libro no está prestado.");
        }
        this.estado = "disponible";
        if (usuarioPrestamo != null) {
            usuarioPrestamo.registrarDevolucion(this);
        }
        this.usuarioPrestamo = null;
    }

    @Override
    public String toString() {
        return "'" + titulo + "' por " + autor + " (" + año + ") - " + estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return año == libro.año &&
               Objects.equals(titulo, libro.titulo) &&
               Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, año);
    }
}