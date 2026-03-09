package com.automation.qa.logica;

import java.util.Arrays;
import java.util.Comparator;

public class OrdenamientoCadenas {

    public String ordenarPalabras(String entrada) {
        String[] palabras = entrada.split(" ");
        Arrays.sort(palabras, Comparator.comparing(String::toLowerCase));
        return String.join(" ", palabras);
    }

    public String ordenarPalabrasPedal(String entrada) {

        String[] palabras = entrada.split(" ");

        for (int i = 0; i < palabras.length - 1; i++) {
            for (int j = 0; j < palabras.length - i - 1; j++) {

                if (palabras[j].toLowerCase().compareTo(palabras[j + 1].toLowerCase()) > 0) {

                    // intercambio
                    String temp = palabras[j];
                    palabras[j] = palabras[j + 1];
                    palabras[j + 1] = temp;
                }
            }
        }

        return String.join(" ", palabras);
    }
}
