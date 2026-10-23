package main.java.br.com.banco.model;

import java.math.BigDecimal;

public class Conta {
    private String numero;
    private String senha;
    private BigDecimal saldo;
    private Cliente titular;
    private TipoConta tipoConta;

    public Conta(Cliente titular,  TipoConta tipoConta) {
        this.titular = titular;
        this.tipoConta = tipoConta;
    }

    // Construtor usado pelo Repository para reconstruir a conta que veio do Banco de Dados
    public Conta(String numero, Cliente titular, TipoConta tipo, BigDecimal saldo) {
        this.numero = numero;
        this.titular = titular;
        this.tipoConta = tipo;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}
