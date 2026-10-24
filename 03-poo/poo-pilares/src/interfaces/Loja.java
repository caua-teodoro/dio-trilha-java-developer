package interfaces;

import interfaces.impressora.Deskjet;
import interfaces.impressora.Impressora;
import interfaces.impressora.Laserjet;
import interfaces.multifuncional.EquipamentoMultifuncional;

public class Loja {
    public static void main(String[] args) {
        Impressora impressora = new Deskjet();
        impressora.imprimir();

        Impressora impressora1 = new Laserjet();
        impressora1.imprimir();

        Impressora eq = new EquipamentoMultifuncional();
        eq.imprimir();
    }
}
