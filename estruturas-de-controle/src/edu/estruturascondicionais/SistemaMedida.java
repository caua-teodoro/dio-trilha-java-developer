package edu.estruturascondicionais;

public class SistemaMedida {
    public static void main(String[] args) {
        char x = 'P';

        switch (x) {
            case 'P':
                System.out.println("Pequeno");
                break;
            case 'M':
                System.out.println("MÉDIO");    
                break;
            case 'G':
                System.out.println("GRANDE");
                break;
            default:
                System.out.println("Não identificado");
        }
    }
    
}
