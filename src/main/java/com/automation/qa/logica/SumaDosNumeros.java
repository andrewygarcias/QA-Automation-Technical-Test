package com.automation.qa.logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumaDosNumeros {

    public String encontrarPar(List<Integer> numeros, int objetivo) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < numeros.size(); i++) {
            int complemento = objetivo - numeros.get(i);
            if (mapa.containsKey(complemento)) {
                return "(" + complemento + ", " + numeros.get(i) + ")";
            }
            mapa.put(numeros.get(i), i);
        }
        return "None";
    }

    public String encontrarParPedal(List<Integer> numeros, int objetivo) {
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i+1; j < numeros.size(); j++) {
                    int suma = numeros.get(i) + numeros.get(j);
                    if (suma == objetivo) {
                        return "(" + numeros.get(i) + ", " + numeros.get(j) + ")";
                    }
            }
        }
        return "None";
    }
}
