package encapsulamento;

// Encapsulamento: nem tudo precisa ser/estar disponível para todos
public class MsnMenssager {
    public void enviarMensagem() {
        validarConectadoInternet();
        System.out.println("Enviando Mensagem");
        salvarHistoricoMensagem();
    }

    public void receberMensagem() {
        validarConectadoInternet();
        System.out.println("Recebendo Mensagem");
        salvarHistoricoMensagem();
    }

    // Encapsulamento
    private void validarConectadoInternet() {
        System.out.println("Validando se está conectado a internet");
    }

    private void salvarHistoricoMensagem() {
        System.out.println("Salvando histórico da mensagem");
    }
}
