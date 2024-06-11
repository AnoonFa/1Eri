package com.ejercicio_1_erick;

import java.util.Scanner;

import clases.Biblioteca;
import clases.Libro;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar libro" );
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    Libro libro = new Libro(titulo, autor, isbn, anio);
                    biblioteca.agregarLibro(libro);
                    break;
                case 2:
                    System.out.print("Ingrese el título del libro: ");
                    titulo = scanner.nextLine();
                    biblioteca.buscarPorTitulo(titulo);
                    break;
                case 3:
                    System.out.print("Ingrese el autor del libro: ");
                    autor = scanner.nextLine();
                    biblioteca.buscarPorAutor(autor);
                    break;
                case 4:
                    biblioteca.mostrarLibros();
                    break;
                case 5:
                    System.out.print("Ingrese el ISBN del libro a prestar: ");
                    isbn = scanner.nextLine();
                    biblioteca.prestarLibro(isbn);
                    break;
                case 6:
                    System.out.print("Ingrese el ISBN del libro a devolver: ");
                    isbn = scanner.nextLine();
                    biblioteca.devolverLibro(isbn);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
