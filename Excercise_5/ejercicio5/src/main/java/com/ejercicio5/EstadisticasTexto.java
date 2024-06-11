package com.ejercicio5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EstadisticasTexto {
    public static void main(String[] args) {
        String nombreArchivo = "texto.txt"; 

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            StringBuilder texto = new StringBuilder();
            while ((linea = lector.readLine()) != null) {
                texto.append(linea).append("\n");
            }
            lector.close();

            String contenido = texto.toString();
            int totalPalabras = contarPalabras(contenido);
            int totalOraciones = contarOraciones(contenido);
            String palabraMasFrecuente = encontrarPalabraMasFrecuente(contenido);
            double longitudPromedio = calcularLongitudPromedio(contenido);

            System.out.println("Estadísticas del texto:");
            System.out.println("Total de palabras: " + totalPalabras);
            System.out.println("Total de oraciones: " + totalOraciones);
            System.out.println("Palabra más frecuente: " + palabraMasFrecuente);
            System.out.println("Longitud promedio de palabras: " + longitudPromedio);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static int contarPalabras(String texto) {
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }

    private static int contarOraciones(String texto) {
        String[] oraciones = texto.split("[.!?]");
        return oraciones.length;
    }

    private static String encontrarPalabraMasFrecuente(String texto) {
        String[] palabras = texto.split("\\s+");
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        for (String palabra : palabras) {
            palabra = palabra.toLowerCase();
            if (!frecuenciaPalabras.containsKey(palabra)) {
                frecuenciaPalabras.put(palabra, 1);
            } else {
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.get(palabra) + 1);
            }
        }

        String palabraMasFrecuente = "";
        int frecuenciaMaxima = 0;
        for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                palabraMasFrecuente = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        return palabraMasFrecuente;
    }

    private static double calcularLongitudPromedio(String texto) {
        String[] palabras = texto.split("\\s+");
        int totalCaracteres = 0;
        for (String palabra : palabras) {
            totalCaracteres += palabra.length();
        }
        return (double) totalCaracteres / palabras.length;
    }
}