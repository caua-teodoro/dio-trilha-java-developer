
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        ArrayList<String> selecionados = selecaoCandidatos();
        imprimirSelecionados(selecionados);

        for (String nome: selecionados) {
            entrandoEmContato(nome);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do { 
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO COM " + candidato + " FOI REALIZADO COM SUCESSO");
            }
            
        } while (continuarTentando && tentativasRealizadas < 3);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados (ArrayList<String> selecionados) {
        System.out.println("=========================================");
        System.out.println("\nImprimindo a lista de candidatos: ");
        for (String nome: selecionados) {
            System.out.println(nome + " foi selecionado para a vaga.");
        }

    }

    static ArrayList<String> selecaoCandidatos() {
        String[] candidatos = {"JOSE", "MARIA", "JOAO", "ANTONIO", "AMAURI", "PEIXOTO"};
        ArrayList<String> selecionados = new ArrayList<>();

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 2 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+ candidato + " solicitou " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println(candidato + " foi selecionado.");
                selecionados.add(candidato);
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }

        return selecionados;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
        }
    }
}
