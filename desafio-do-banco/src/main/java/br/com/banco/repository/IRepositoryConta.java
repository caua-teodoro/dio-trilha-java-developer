package main.java.br.com.banco.repository;

import main.java.br.com.banco.model.Cliente;
import main.java.br.com.banco.model.Conta;

import java.math.BigDecimal;

public interface IRepositoryConta extends IRepository<Conta> {
    void depositar(String numero, BigDecimal valor);
    void sacar(String numero, BigDecimal valor);
    void transferir(BigDecimal valor, String numRemetente, String numDestinatario);
    void definirSenha(String numero, String senha);
}
