package models;

public class Carro extends Veiculo {

    public Carro() {
    }

    public Carro(String marca, int ano, double consumoPorKm, String modelo) {
        super(marca, ano, consumoPorKm, modelo);
    }

    @Override
    public String toString() {
        return "Carro{} " + super.toString();
    }
}
