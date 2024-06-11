package com.ejercicios4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaPalabras {
    private static final List<String> palabras = new ArrayList<>();

    static {
        cargarPalabras();
    }

    private static void cargarPalabras() {
        palabras.add("carro");
        palabras.add("moto");
    }

    public static String seleccionarPalabra() {
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size()));
    }
}
