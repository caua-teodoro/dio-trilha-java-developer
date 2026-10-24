package heranca_abstracao_polimorfismo;

import heranca_abstracao_polimorfismo.abstrata.ServicoMensagemInstantanea;

public class Telegram extends ServicoMensagemInstantanea {
    @Override
    public void enviarMensagem() {
        validarConectadoInternet();
        System.out.println("Mensagem enviada no Telegram");
        salvarHistoricoMensagem();
    }
    @Override
    public void receberMensagem() {
        validarConectadoInternet();
        System.out.println("Mensagem recebida no Telegram");
        salvarHistoricoMensagem();
    }
}
