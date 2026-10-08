package introducao;

public class Autodromo {
    public static void main(String[] args) {
        Carro jeep = new Carro();
        // jeep.conferirCombustivel();
        // jeep.ligar();
        // jeep.setChassi("564102016");
        Moto z400 = new Moto();


        // Polimorfismo
        Veiculo v1 = new Moto();
        v1.ligar();

        Veiculo v2 = new Carro();
        v2.ligar();
    }
    
}
