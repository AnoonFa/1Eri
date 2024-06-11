package com.ejercicio_3.clases;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuarios {
    private List <Usuario> usuarios;

    public Usuarios() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado con éxito.");
    }

    public void buscarPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(usuario);
            }
        }
    }

   public void eliminarUsuario(Scanner scanner, String nombreEliminar) {
    if (usuarios.isEmpty()) {
        System.out.println("No hay usuarios para eliminar.");
        return;
    }

    boolean usuarioEncontrado = false;
    for (Usuario usuario : usuarios) {
        if (usuario.getNombre().equalsIgnoreCase(nombreEliminar)) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado.");
            usuarioEncontrado = true;
            break;
        }
    }

    if (!usuarioEncontrado) {
        System.out.println("No se encontró ningún usuario con ese nombre.");
    }
}


    public void mostrarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

}