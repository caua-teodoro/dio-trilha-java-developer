package introducao;

public abstract class Veiculo {
    private String chassi;

    public String getChassi() {
        return this.chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    public abstract void ligar();
}
