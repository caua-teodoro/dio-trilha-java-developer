package edu.estruturascondicionais;

public class Boletim {
    public static void main(String[] args) {
        double nota = 6;
        
        // composto
        // if (nota < 7) {
        //     System.out.println("Reprovado!");
        // } else {
        //     System.out.println("Aprovado.");
        // }

        if (nota < 6) {
            System.out.println("Reprovado");
        } else if (nota >= 6 && nota < 7) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Aprovado");
        }

        // Operador Ternário
        double nota2 = 10;
        String resultado = (nota2 < 6) ? ((nota2 >= 6 && nota < 7) ? "Recuperação" : "Reprovado"): "Aprovado";
        System.out.println(resultado);
    }
}
