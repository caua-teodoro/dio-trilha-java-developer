package escola;

public class Aluno {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno () {
        
    }

    public String getNome () {
        return this.nome;
    }

    public void setNome (String novoNome) {
        this.nome = novoNome;
    }

    public int getIdade () {
        return this.idade;
    }

    public void setIdade (int novaIdade) {
        this.idade = novaIdade;
    }
}
