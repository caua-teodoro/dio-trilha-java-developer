package lanchonete.atendimento.cozinha;

public class Cozinheiro {
    public void adicionarLancheNoBalcao() {
        System.out.println("ADICIONANDO LANCHE NATURAL HAMBURGUER NO BALCAO");
    }

    public void pedirIngredientes(Almoxarife almoxarife) {
        almoxarife.entregarIngredientes();
    }

    // public void pedirParaTrocarGas(Atendente meuAmigo) {
    //     meuAmigo.trocarGas();
    // } não permitido

    public void pedirParaTrocarGas(Almoxarife meuAmigo) {
        meuAmigo.trocarGas();
    }

    private void lavarIngredientes() {
        System.out.println("LAVANDO INGREDIENTES");
    }
    
    private void baterVitamina() {
        System.out.println("BATENDO A VITAMINA");
    }

    private void selecionarIngredientes() {
        System.out.println("SELECIONANDO INGREDIENTES");
    }
}
