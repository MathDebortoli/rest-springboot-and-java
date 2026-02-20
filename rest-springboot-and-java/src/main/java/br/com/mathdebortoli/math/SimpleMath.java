package br.com.mathdebortoli.math;


public class SimpleMath {

    public Double soma (Double numeroUm, Double numeroDois) {
        return numeroUm + numeroDois;
    }

    public Double subtracao (Double numeroUm, Double numeroDois) {
        return numeroUm - numeroDois;
    }

    public Double multiplicacao (Double numeroUm, Double numeroDois) {
        return numeroUm * numeroDois;
    }

    public Double divisao (Double numeroUm, Double numeroDois) {
        return numeroUm / numeroDois;
    }

    public Double media (Double numeroUm, Double numeroDois) {
        return (numeroUm + numeroDois)/2;
    }

    public Double raizquadrada(Double numero) {
        return Math.sqrt(numero);
    }
}
