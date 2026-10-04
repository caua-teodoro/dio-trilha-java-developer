public class SmartTv {
    boolean ligada;
    int canal;
    int volume;
    
    public void ligar() {
        this.ligada = true;
    }

    public void desligar() {
        this.ligada = false;
    }

    public void aumentar () {
        this.volume += 1;
    }

    public void diminuir () {
        this.volume -= 1;
    }

    public void mudarCanal (int canal) {
        this.canal =  canal;
    } 
}