package models;

public class Moto extends Veiculo{
    private int cilindradas;

    public Moto(){
      cilindradas = 50;
    }

    public Moto(String marca, int ano,
                double consumoPorKm, String modelo,
                int cilindradas) {
        super(marca, ano, consumoPorKm, modelo);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindradas=" + cilindradas +
                "} " + super.toString();
    }
}
