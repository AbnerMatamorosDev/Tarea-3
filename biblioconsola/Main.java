package com.miproyecto.biblioconsola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Agregar algunos libros a la biblioteca (literatura japonesa)
        biblioteca.agregarLibro(new Libro("Indigno de ser Humano", "Osamu Dazai", 1948, "Novela", true));
        biblioteca.agregarLibro(new Libro("Confesiones de una máscara", "Yukio Mishima", 1949, "Novela", true));
        biblioteca.agregarLibro(new Libro("El pabellón de oro", "Yukio Mishima", 1956, "Novela", true));

        while (true) {
            System.out.println("\n--- Menú de Biblioteca ---");
            System.out.println("a. Agregar libro");
            System.out.println("b. Buscar libros");
            System.out.println("c. Prestar libro");
            System.out.println("d. Devolver libro");
            System.out.println("e. Mostrar libros disponibles");
            System.out.println("f. Salir");
            System.out.print("Elija una opción: ");
            
            char opcion = scanner.next().charAt(0);
            scanner.nextLine();  // Consumir el salto de línea
            
            switch (opcion) {
                case 'a':
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese el género del libro: ");
                    String genero = scanner.nextLine();
                    biblioteca.agregarLibro(new Libro(titulo, autor, anio, genero, true));
                    System.out.println("Libro agregado exitosamente.");
                    break;
                case 'b':
                    System.out.print("Ingrese el título o autor para buscar: ");
                    String query = scanner.nextLine();
                    System.out.println("Resultados de la búsqueda:");
                    for (Libro libro : biblioteca.buscarLibros(query)) {
                        System.out.println(libro);
                    }
                    break;
                case 'c':
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    if (biblioteca.prestarLibro(tituloPrestar)) {
                        System.out.println("Libro prestado exitosamente.");
                    } else {
                        System.out.println("El libro no está disponible o no se encontró.");
                    }
                    break;
                case 'd':
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    if (biblioteca.devolverLibro(tituloDevolver)) {
                        System.out.println("Libro devuelto exitosamente.");
                    } else {
                        System.out.println("El libro no está prestado o no se encontró.");
                    }
                    break;
                case 'e':
                    System.out.println("Libros disponibles:");
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 'f':
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
