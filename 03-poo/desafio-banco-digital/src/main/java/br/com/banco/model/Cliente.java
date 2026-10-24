package main.java.br.com.banco.model;

public class Cliente {
    private Long id; // ID gerado pelo banco de dados (Chave Primária)
    private String nome;
    private String cpf;

    // Construtor para cliente novo (ainda sem ID do banco)
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    // Construtor para cliente vindo do banco de dados (já tem ID)
    public Cliente(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
}
