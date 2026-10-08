package escola;

import java.util.ArrayList;

public class Escola {

    ArrayList<Aluno> alunosCadastrados;

    public Escola () {
        this.alunosCadastrados = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        this.alunosCadastrados.add(aluno);
    }

    public void verListaAlunos() {
        for (Aluno a:this.alunosCadastrados) {
            System.out.println(a.getNome() + " - " + a.getIdade());
        }
    }

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("José Vitor", 11);
        Aluno aluno2 = new Aluno("Ana Castro", 10);

        Escola ete = new Escola();

        ete.cadastrarAluno(aluno1);
        ete.cadastrarAluno(aluno2);

        ete.verListaAlunos();
    }
}
