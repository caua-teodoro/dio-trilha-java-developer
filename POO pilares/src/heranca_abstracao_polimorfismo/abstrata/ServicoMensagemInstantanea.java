package heranca_abstracao.abstrata;

public abstract class ServicoMensagemInstantanea {
    // Abstração ideia: Para você ser é preciso voce fazer
    public abstract void enviarMensagem();

    public abstract void receberMensagem();

    protected void validarConectadoInternet() {
        System.out.println("Dispositivo conectado a internet");
    }

    protected void salvarHistoricoMensagem() {
        System.out.println("Salvando Mensagem no histórico");
    }
}
