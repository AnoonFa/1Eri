package com.ejercicio_3;

import java.util.Scanner;

import com.ejercicio_3.clases.Usuario;
import com.ejercicio_3.clases.Usuarios;;

public class Main {

    public static void main(String[] args) {
        Usuarios Usuarios = new Usuarios();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar contacto" );
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar contactos");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Correo Electronico: ");
                    String correoElectronico = scanner.nextLine();
                    scanner.nextLine(); // Limpiar el buffer
                    Usuario Usuario = new Usuario(correoElectronico,nombre,telefono);
                    Usuarios.agregarUsuario(Usuario);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Usuario: ");
                    nombre = scanner.nextLine();
                    Usuarios.buscarPorNombre(nombre);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    Usuarios.eliminarUsuario(scanner, scanner.nextLine());
                    break;
                case 4:
                    Usuarios.mostrarUsuarios();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
