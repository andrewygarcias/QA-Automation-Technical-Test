package com.automation.qa.stepdefinitions.retoslogica;

import com.automation.qa.logica.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RetosLogicaStepsDefinitions {

    private int numero;
    private String resultado;
    private String entrada;
    private int n;
    private List<Integer> lista;
    private int objetivo;

    @Dado("que tengo el numero {int}")
    public void dadoQueTengoElNumero(int numero) {
        this.numero = numero;
    }

    @Cuando("evaluo si es primo")
    public void evaluoSiEsPrimo() {
        this.resultado = new NumeroPrimo().esPrimo(numero);
    }

    @Entonces("el resultado debe ser {word}")
    public void entoncesElResultadoDebeSer(String esperado) {
        assertThat(resultado).isEqualTo(esperado);
    }

    @Dado("que tengo la cadena {string}")
    public void dadoQueTengoLaCadena(String cadena) {
        this.entrada = cadena;
    }

    @Cuando("ordeno las palabras alfabeticamente")
    public void ordenoLasPalabrasAlfabeticamente() {
        this.resultado = new OrdenamientoCadenas().ordenarPalabrasPedal(entrada);
    }

    @Entonces("el resultado debe ser {string}")
    public void entoncesElResultadoOrdenadoDebeSer(String esperado) {
        assertThat(resultado).isEqualTo(esperado);
    }

    @Cuando("verifico si es palindromo")
    public void verificoSiEsPalindromo() {
        this.resultado = new Palindromo().esPalindromo(entrada);
    }

    @Entonces("el resultado del palindromo debe ser {word}")
    public void entoncesElResultadoPalindromoDebeSer(String esperado) {
        assertThat(resultado).isEqualTo(esperado);
    }

    @Dado("que quiero generar los primeros {int} numeros de fibonacci")
    public void dadoQueQuieroGenerarFibonacci(int n) {
        this.n = n;
    }

    @Cuando("genero la secuencia")
    public void generoLaSecuencia() {
        this.resultado = new Fibonacci().generarSecuencia(n).toString();
    }

    @Entonces("la secuencia debe ser {string}")
    public void entoncesLaSecuenciaDebeSer(String esperado) {
        assertThat(resultado).isEqualTo(esperado);
    }

    @Dado("que tengo la lista {string} y el objetivo {int}")
    public void dadoQueTengoLaListaYObjetivo(String listaStr, int objetivo) {
        this.lista = Arrays.stream(listaStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.objetivo = objetivo;
    }

    @Cuando("busco el par con la suma objetivo")
    public void buscoElParConLaSumaObjetivo() {
        this.resultado = new SumaDosNumeros().encontrarParPedal(lista, objetivo);
    }

    @Entonces("el par encontrado debe ser {string}")
    public void entoncesElParEncontradoDebeSer(String esperado) {
        assertThat(resultado).isEqualTo(esperado);
    }
}


