package edu.tratamentoexcecoes;

public class CepInvalidoException extends Exception {

    @Override
    public String getMessage() {
        return "Formato do CEP está inválido.";
    }
    
}
