package com.automation.qa.logica;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public List<Integer> generarSecuencia(int n) {
        List<Integer> secuencia = new ArrayList<>();
        if (n <= 0)
            return secuencia;
        secuencia.add(0);
        if (n == 1)
            return secuencia;
        secuencia.add(1);
        for (int i = 2; i < n; i++) {
            secuencia.add(secuencia.get(i - 1) + secuencia.get(i - 2));
        }
        return secuencia;
    }
}
