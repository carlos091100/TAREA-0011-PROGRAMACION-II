package com.cr.GestionBiblioteca.interfaz;

import com.cr.GestionBiblioteca.entity.Usuario;

public interface Gestionable {
    void prestar(Usuario usuario);
    void devolver();
}