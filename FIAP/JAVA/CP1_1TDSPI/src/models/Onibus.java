package models;

public class Onibus extends Veiculo{
    private int capacidadeDePassageiros;
    private int passageiros;

    public Onibus(){
        capacidadeDePassageiros = 20;
    }

    public Onibus(String marca, int ano, double consumoPorKm,
                  String modelo, int capacidadeDePassageiros,
                  int passageiros) {
        super(marca, ano, consumoPorKm, modelo);
        this.capacidadeDePassageiros = capacidadeDePassageiros;
        embarcarPassageiros(passageiros);
    }

    public int getCapacidadeDePassageiros() {
        return capacidadeDePassageiros;
    }

    public void setCapacidadeDePassageiros(int capacidadeDePassageiros) {
        this.capacidadeDePassageiros = capacidadeDePassageiros;
    }

    public int getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(int passageiros) {
        embarcarPassageiros(passageiros);
        this.passageiros = passageiros;
    }

    @Override
    public String toString() {
        return "Onibus{" +
                "capacidadeDePassageiros=" + capacidadeDePassageiros +
                ", passageiros=" + passageiros +
                "} " + super.toString();
    }

    public void embarcarPassageiros(int passageiros){
        if(passageiros < 0 || passageiros > capacidadeDePassageiros){
            System.out.println("A quantidade de passageiros não pode ser negativa \r\n" +
                    "ou maior que a capacidade do ônibus.");
            return;
        }
        this.passageiros += passageiros;
    }
}
