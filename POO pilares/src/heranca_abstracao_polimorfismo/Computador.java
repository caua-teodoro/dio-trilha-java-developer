package heranca_abstracao_polimorfismo;

import heranca_abstracao_polimorfismo.abstrata.ServicoMensagemInstantanea;

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
