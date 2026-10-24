
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Informe o Número: ");
        int numero = scanner.nextInt();

        System.out.println("Informe a Agência: ");
        String agencia = scanner.next();
        String capturaEnter = scanner.nextLine();

        System.out.println("Informe seu nome: ");
        String nome = scanner.nextLine();
        
        System.out.println("Informe seu saldo: ");
        double saldo = scanner.nextDouble();    

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.5f já está disponível para saque", nome, agencia, numero, saldo);
    }
}
