package edu.estruturasderepeticao;

import java.util.concurrent.ThreadLocalRandom;

public class ExemploWhile {
    public static void main(String[] args) {
        double mesada = 50.0;

        while(mesada > 0) {
            Double valorDoce = valorAletorio();
            if (mesada > valorDoce) {
                System.out.println("Doce do valor: " + valorDoce + " Adicionado no carrinho");
                mesada = mesada - valorDoce;
            } else {
                mesada = -1;
                mesada = -1;
            }
        }
    }

    private static double valorAletorio() {
        return ThreadLocalRandom.current().nextDouble(2, 8);
    }
}
