package com.cr.GestionBiblioteca.main;

import java.util.List;
import java.util.stream.Collectors; // ← IMPORTANTE
import com.cr.GestionBiblioteca.entity.Libro;
import com.cr.GestionBiblioteca.entity.Usuario;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        Usuario usuario1 = new Usuario("carlos Perez", "1234");

        System.out.println(libro1);
        System.out.println(usuario1);

        // Prestar libro
        libro1.prestar(usuario1);
        System.out.println("\nDespués del préstamo:");
        System.out.println(libro1);

        List<Libro> prestados = usuario1.getLibrosPrestados();
        System.out.println("Libros prestados por " + usuario1.getNombre() + ": " +
                prestados.stream().map(Libro::getTitulo).collect(Collectors.toList()));

        // Devolver libro
        libro1.devolver();
        System.out.println("\nDespués de la devolución:");
        System.out.println(libro1);
        System.out.println("Libros prestados por " + usuario1.getNombre() + ": " +
                usuario1.getLibrosPrestados().stream().map(Libro::getTitulo).collect(Collectors.toList()));
    }
}