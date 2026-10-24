package edu.estruturasderepeticao;

public class ExemploFor {
    public static void main(String[] args) {
        // for (int i = 0; i < 20; i++) {
        //     System.out.println("Contador: " + i);
        // }

        int i = 0;
        for (; i < 20; i++) {
            System.out.println("i: " + i);
        }

        System.out.println("\n==========================\n");

        String alunos[] = {"FELIPE", "JOSÉ", "JONAS", "JULIA", "MARCOS"}; 
        
        for (int x = 0; x < alunos.length; x++) {
            System.out.println(alunos[x]);
        }

        System.out.println("\n==========================\n");
        
        // For each
        for(String aluno:alunos) {
            System.out.println(aluno);
        }
    }
}
