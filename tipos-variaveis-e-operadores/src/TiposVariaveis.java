public class TiposVariaveis {
    public static void main(String[] args) {
        byte idade = 123;
		short ano = 2021;
		int cep = 21070333; // se começar com zero, talvez tenha que ser outro tipo
		long cpf = 98765432109L; // se começar com zero, talvez tenha que ser outro tipo
		float pi = 3.14F;
		double salario = 1275.33;

        // Java é Fortemente tipado
        short numeroCurto = 1;
        int numeroNormal = numeroCurto;
        //erro short numeroCurto2 = numeroNormal;
        short numeroCurto2 = (short) numeroNormal;

        // Constantes
        int numero = 5;
        numero = 10;
        System.out.println(numero);

        final double PI = 3.14;
        //erro PI = 4;
    }
}