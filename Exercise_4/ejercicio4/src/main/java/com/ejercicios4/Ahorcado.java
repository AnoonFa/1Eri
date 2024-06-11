package com.ejercicios4;

import java.util.Scanner;

public class Ahorcado {
    private static final int MAX_INTENTOS = 6;

    public static void main(String[] args) {
        String palabraSecreta = ListaPalabras.seleccionarPalabra();
        StringBuilder progreso = new StringBuilder("*".repeat(palabraSecreta.length()));

        int intentos = 0;
        Scanner scanner = new Scanner(System.in);
        while (intentos < MAX_INTENTOS) { 
            System.out.println("Intentos: " + (MAX_INTENTOS - intentos));
            System.out.println("La palabra que buscas esss: " + progreso);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().charAt(0);

            if (!actualizarProgreso(palabraSecreta, progreso, letra)) {
                intentos++;
            }

            if (progreso.toString().equals(palabraSecreta)) {
                System.out.println("Muy bieen, la palabra que buscabas era: " + palabraSecreta);
                return;
            }
        }

        System.out.println("Noo lo ahorcaroon vuelve a ¡¡intentarlo!!: " + palabraSecreta);
    }

    private static boolean actualizarProgreso(String palabraSecreta, StringBuilder progreso, char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso.setCharAt(i, letra);
                acierto = true;
            }
        }
        if (!acierto) {
            System.out.println("La letra '" + letra + "' no esta aqui");
        }
        return acierto;
    }
}
