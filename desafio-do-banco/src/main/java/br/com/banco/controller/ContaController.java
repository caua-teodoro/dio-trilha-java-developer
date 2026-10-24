package main.java.br.com.banco.controller;

import main.java.br.com.banco.exception.RegraDeNegocioException;
import main.java.br.com.banco.model.Conta;
import main.java.br.com.banco.model.TipoConta;
import main.java.br.com.banco.service.ContaService;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

/**
 * Camada Controller.
 * Faz o meio de campo entre a interface do usuário (tela/terminal) e o Service.
 * Captura exceções de negócio e formata respostas amigáveis.
 */
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    public String criarConta(String nome, String cpf, int opcaoTipo) {
        try {
            TipoConta tipo = (opcaoTipo == 1) ? TipoConta.CORRENTE : TipoConta.POUPANCA;
            Conta conta = contaService.abrirConta(nome, cpf, tipo);
            return "[SUCESSO] " + conta.getTipoConta().getDescricao() + " nº " + conta.getNumero() +
                    " criada para " + conta.getTitular().getNome() + "!";
        } catch (RegraDeNegocioException e) {
            return "[ERRO] " + e.getMessage();
        }
    }

    public String realizarDeposito(String numeroConta, BigDecimal valor) {
        try {
            contaService.depositar(numeroConta, valor);
            return "[SUCESSO] Depósito de R$ " + valor + " realizado na conta " + numeroConta + ".";
        } catch (RegraDeNegocioException e) {
            return "[ERRO] " + e.getMessage();
        }
    }

    public String realizarSaque(String numeroConta, BigDecimal valor) {
        try {
            contaService.sacar(numeroConta, valor);
            return "[SUCESSO] Saque de R$ " + valor + " realizado na conta " + numeroConta + ".";
        } catch (RegraDeNegocioException e) {
            return "[ERRO] " + e.getMessage();
        }
    }

    public String realizarTransferencia(String numOrigem, String numDestino, BigDecimal valor) {
        try {
            contaService.transferir(numOrigem, numDestino, valor);
            return "[SUCESSO] Transferência de R$ " + valor + " de " + numOrigem + " para " + numDestino + " concluída.";
        }  catch (RegraDeNegocioException e) {
            return "[ERRO] " + e.getMessage();
        }
    }

    public String exibirResumoContas() {
        List<Conta> contas = contaService.listarContas();
        if (contas.isEmpty()) {
            return "Nenhuma conta cadastrada no momento.";
        }

        StringBuilder sb = new StringBuilder("\n=== LISTA DE CONTAS ===\n");
        for (Conta c : contas) {
            sb.append(String.format("Conta: %s | Tipo: %s | Titular: %s (CPF: %s) | Saldo: R$ %.2f%n",
                    c.getNumero(),
                    c.getTipoConta().getDescricao(),
                    c.getTitular().getNome(),
                    c.getTitular().getCpf(),
                    c.getSaldo()));
        }
        return sb.toString();
    }
}
