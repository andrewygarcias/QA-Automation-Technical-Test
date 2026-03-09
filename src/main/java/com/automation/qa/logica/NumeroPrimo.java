package com.automation.qa.logica;

public class NumeroPrimo {

    public  String esPrimo(int numero) {
        if (numero < 2)
            return "Falso";
        if (numero == 2)
            return "Verdadero";
        if (numero % 2 == 0)
            return "Falso";
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0)
                return "Falso";
        }
        return "Verdadero";
    }


    }

