package clases;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List <Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado con éxito.");
    }

    public void buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(libro);
            }
        }
    }

    public void buscarPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(libro);
            }
        }
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void prestarLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.prestar();
                return;
            }
        }
        System.out.println("No se encontró un libro con ese ISBN.");
    }

    public void devolverLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.devolver();
                return;
            }
        }
        System.out.println("No se encontró un libro con ese ISBN.");
    }
}
