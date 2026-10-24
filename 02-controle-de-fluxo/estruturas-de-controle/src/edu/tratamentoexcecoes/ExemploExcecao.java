package edu.tratamentoexcecoes;

import java.text.NumberFormat;

public class ExemploExcecao {
    public static void main(String[] args) {
        // Exceções nao checadas - RunTimeException
        // Number valor = Double.valueOf("a1.75");
        // System.out.println(valor);


        // Exceções checadas - Exception
        try {
            Number valor = NumberFormat.getInstance().parse("a1.75");
            System.out.println(valor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
}
