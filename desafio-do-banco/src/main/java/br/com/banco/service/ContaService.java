package main.java.br.com.banco.service;

import main.java.br.com.banco.exception.RegraDeNegocioException;
import main.java.br.com.banco.model.Cliente;
import main.java.br.com.banco.model.Conta;
import main.java.br.com.banco.model.TipoConta;
import main.java.br.com.banco.repository.IRepositoryCliente;
import main.java.br.com.banco.repository.IRepositoryConta;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Camada de Negócio (Service).
 * Aqui ficam todas as validações e regras do banco.
 */

public class ContaService {
    private final IRepositoryConta repositoryConta;
    private final IRepositoryCliente repositoryCliente;

    // Injeção de dependência via construtor
    public ContaService(IRepositoryConta repository, IRepositoryCliente repositoryCliente) {
        this.repositoryConta = repository;
        this.repositoryCliente = repositoryCliente;
    }

    public Conta abrirConta(String nomeCliente, String cpf, TipoConta tipoConta) {
        String num;
        while(true) {
            Random rand = new Random();
            num = String.valueOf(rand.nextInt(9000) + 1000);
            if (!this.repositoryConta.existe(num)) {
                break;
            }
        }
        Cliente titular;
        if (repositoryCliente.existe(cpf)) {
            // Cliente já existe: busca ele do banco (já vem com o mesmo ID!)
            Optional<Cliente> clienteExistente = repositoryCliente.buscar(cpf);
            titular = clienteExistente.get();
        } else {
            // Cliente não existe: cria, cadastra no banco (para ganhar o ID) e usa ele
            titular = new Cliente(nomeCliente, cpf);
            repositoryCliente.cadastrar(Optional.of(titular));
        }
        Conta newConta = new Conta(num, titular, tipoConta, BigDecimal.ZERO);
        this.repositoryConta.cadastrar(Optional.of(newConta));
        return newConta;
    }

    public void depositar(String numero, BigDecimal valor) {
        validarValorPositivo(valor);
        Optional<Conta> conta = buscarConta(numero);
        this.repositoryConta.depositar(numero, valor);
    }

    public void sacar(String numeroConta, BigDecimal valor) {
        validarValorPositivo(valor);
        Optional<Conta> conta = buscarConta(numeroConta);

        if (conta.get().getSaldo().compareTo(valor) < 0) {
            throw new RegraDeNegocioException("Saldo insuficiente. Saldo atual: R$ " + conta.get().getSaldo());
        }

        this.repositoryConta.sacar(numeroConta, valor);
    }

    public void transferir(String numeroOrigem, String numeroDestino, BigDecimal valor) {
        if (numeroOrigem.equals(numeroDestino)) {
            throw new RegraDeNegocioException("A conta de destino não pode ser igual à conta de origem.");
        }
        this.repositoryConta.transferir(valor, numeroOrigem, numeroDestino);
    }

    public Optional<Conta> consultarConta(String numeroConta) {
        return buscarConta(numeroConta);
    }

    public List<Optional<Conta>> listarContas() {
        return repositoryConta.listar();
    }

    private Optional<Conta> buscarConta(String numero) {
        try {
            return repositoryConta.buscar(numero);
        } catch (RegraDeNegocioException ex) {
            throw new RegraDeNegocioException("Conta '" + numero + "' não encontrada.");
        }

    }

    private void validarValorPositivo(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("O valor da operação deve ser maior que zero.");
        }
    }

}
