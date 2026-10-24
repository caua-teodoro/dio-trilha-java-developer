package main.java.br.com.banco;

import main.java.br.com.banco.controller.ContaController;
import main.java.br.com.banco.repository.IRepositoryCliente;
import main.java.br.com.banco.repository.IRepositoryConta;
import main.java.br.com.banco.repository.RepositoryCliente;
import main.java.br.com.banco.repository.RepositoryConta;
import main.java.br.com.banco.service.ContaService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Instanciando as camadas na ordem correta (Injeção de Dependência Manual)
        IRepositoryConta repositoryConta = new RepositoryConta();
        IRepositoryCliente repositoryCliente = new RepositoryCliente();

        ContaService contaService = new ContaService(repositoryConta, repositoryCliente);

        ContaController contaController = new ContaController(contaService);

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========= BANCO JAVA =========");
            System.out.println("1 - Abrir Nova Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Listar Contas e Saldos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do titular: ");
                    String cpf = sc.nextLine();
                    System.out.print("Tipo (1 - Corrente | 2 - Poupança): ");
                    int tipo = Integer.parseInt(sc.nextLine());

                    System.out.println(contaController.criarConta(nome, cpf, tipo));
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();
                    System.out.print("Valor do depósito (ex: 150.50): ");
                    BigDecimal valor = new BigDecimal(sc.nextLine());

                    System.out.println(contaController.realizarDeposito(numero, valor));
                    break;
                case 3:
                    System.out.print("Número da conta: ");
                    numero = sc.nextLine();
                    System.out.print("Valor do saque (ex: 50.00): ");
                    valor = new BigDecimal(sc.nextLine());

                    System.out.println(contaController.realizarSaque(numero, valor));
                    break;
                case 4:
                    System.out.print("Conta de Origem: ");
                    String origem = sc.nextLine();
                    System.out.print("Conta de Destino: ");
                    String destino = sc.nextLine();
                    System.out.print("Valor da transferência: ");
                    valor = new BigDecimal(sc.nextLine());

                    System.out.println(contaController.realizarTransferencia(origem, destino, valor));
                    break;
                case 5:
                    System.out.println(contaController.exibirResumoContas());
                    break;
                case 0:
                    System.out.println("Encerrando o sistema bancário. Até logo!");
                    opcao = 0;
                    break;
                default:
                    System.out.println("[ERRO] Opção inválida.");
            }


        }

        sc.nextLine();

    }
}
