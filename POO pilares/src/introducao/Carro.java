package introducao;

public class Carro extends Veiculo {
    public void ligar() {
        conferirCombustivel();
        System.out.println("CARRO LIGADO");
    }
    //encapsulamento
    private void conferirCombustivel() {
        System.out.println("CONFERINDO COMBUSTÍVEL");
    }
}
