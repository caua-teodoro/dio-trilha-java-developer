
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o primeiro parâmetro:");
        int param1 = scanner.nextInt();

        System.out.println("Informe o segundo parâmetro:");
        int param2 = scanner.nextInt();

        try {
            contar(param1, param2);
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }
        

        scanner.close();
    }

    static void contar(int parametro1, int parametro2) throws ParametrosInvalidosException {
        if (parametro1 > parametro2) throw new ParametrosInvalidosException();

        int intervalo = parametro2 - parametro1;
        for (int i = 0; i < intervalo; i++) {
            System.out.println("Imprimindo o númeoro " + (i+1));
        }
    }
}
