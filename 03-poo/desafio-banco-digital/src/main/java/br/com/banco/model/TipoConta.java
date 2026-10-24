package main.java.br.com.banco.model;

public enum TipoConta {
    CORRENTE("Conta Corrente"),
    POUPANCA("Conta Poupança");

    private String descricao;

    TipoConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
