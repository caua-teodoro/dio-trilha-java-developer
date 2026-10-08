package heranca_abstracao;

import heranca_abstracao.abstrata.ServicoMensagemInstantanea;

public class Computador {
    public static void main(String[] args) {
        // Polimorfismo
        ServicoMensagemInstantanea app1 = new Telegram();

        ServicoMensagemInstantanea app2 = new Facebook();

        app1.enviarMensagem();

        System.out.println();
        app2.receberMensagem();

    }
}
