package edu.tratamentoexcecoes;

public class CepFormatador {
    public static void main(String[] args) {

        try {
            String resultado = formatarCep("11123564");
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static String formatarCep (String cep) throws CepInvalidoException {
        if (cep.length() != 8) throw new CepInvalidoException();

        return "CORRETO CEP";
    }
}
