package heranca_abstracao;

import heranca_abstracao.abstrata.ServicoMensagemInstantanea;

public class Facebook extends ServicoMensagemInstantanea {
    @Override
    public void enviarMensagem() {
        validarConectadoInternet();
        System.out.println("Mensagem enviada no Telegram");
        validarConectadoInternet();
    }

    @Override
    public void receberMensagem() {
        validarConectadoInternet();
        System.out.println("Mensagem recebida no Telegram");
        validarConectadoInternet();
    }
}
