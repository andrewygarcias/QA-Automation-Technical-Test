package com.automation.qa.logica;

public class Palindromo {

    public String esPalindromo(String cadena) {
        String limpia = cadena.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = limpia.length() - 1;
        while (i < j) {
            if (limpia.charAt(i) != limpia.charAt(j))
                return "Falso";
            i++;
            j--;
        }
        return "Verdadero";
    }
}
