package edu.tratamentoexcecoes;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

            System.out.println("Digite a idade:");
            int idade = scanner.nextInt();

            System.out.println("Idade: " + idade);

            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println("Campo idade está inválido.");
        }
    }
    
}
