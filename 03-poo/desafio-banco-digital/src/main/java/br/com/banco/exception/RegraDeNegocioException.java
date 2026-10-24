package main.java.br.com.banco.exception;

public class RegraDeNegocioException extends RuntimeException {
    public RegraDeNegocioException(String message) {
        super(message);
    }
}
