package com.miproyecto.biblioconsola;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    // Constructor
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    // Método para agregar un libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Método para buscar libros por título o autor
    public List<Libro> buscarLibros(String query) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(query.toLowerCase()) || 
                libro.getAutor().toLowerCase().contains(query.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    // Método para prestar un libro
    public boolean prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponibilidad()) {
                libro.setDisponibilidad(false);
                return true;
            }
        }
        return false;
    }

    // Método para devolver un libro
    public boolean devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isDisponibilidad()) {
                libro.setDisponibilidad(true);
                return true;
            }
        }
        return false;
    }

    // Método para mostrar todos los libros disponibles
    public void mostrarLibrosDisponibles() {
        for (Libro libro : libros) {
            if (libro.isDisponibilidad()) {
                System.out.println(libro);
            }
        }
    }
}
