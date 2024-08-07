package models;

import java.time.LocalDateTime;

public class Veiculo {
    protected String marca;
    protected int ano;
    protected double consumoPorKm;
    protected String modelo;
    protected double combustivelNoTanque;
    protected double quilometragem;

    public Veiculo(){
        
    }

    public Veiculo(String marca, int ano, double consumoPorKm, String modelo) {
        this.marca = marca;
        this.ano = ano;
        this.consumoPorKm = consumoPorKm;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(ano < 1886 || ano > LocalDateTime.now().getYear()) {
            System.out.println
                    ("O carro não pode ser mais antigo que 1886 ou mais novo que o ano atual");
            return;
        }
        this.ano = ano;
    }

    public double getConsumoPorKm() {
        return consumoPorKm;
    }

    public void setConsumoPorKm(double consumoPorKm) {
        this.consumoPorKm = consumoPorKm;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCombustivelNoTanque() {
        return combustivelNoTanque;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", ano=" + ano +
                ", consumoPorKm=" + consumoPorKm +
                ", modelo='" + modelo + '\'' +
                ", combustivelNoTanque=" + combustivelNoTanque +
                ", quilometragem=" + quilometragem +
                '}';
    }

    public void abastecer(double litros){
        combustivelNoTanque += litros;
        System.out.println("Abastecendo " + litros + "litros no tanque.");
    }

    //Reduzir a quantidade de combustível no tanque com base na distância percorrida e no consumo por quilômetro do carro.
    //Aumentar a quilometragem do veiculo.
    //Caso não haja combustível suficiente para a distância desejada, o carro não deve "dirigir" e deve imprimir uma mensagem indicando falta de combustível.
    // se eu quero diririgir 100km e o veiculo faz 10km/l, eu precisaria de 10 litros de combustivel
    public void dirigir(double distancia){
        double combustivelNecessario = distancia / consumoPorKm; // ex: 100km / 10km/l = 10 litros
        if(combustivelNoTanque >= combustivelNecessario){
            combustivelNoTanque -= combustivelNecessario;
            quilometragem += distancia;
            System.out.println("Dirigindo "+ distancia +" km");
        }
        else
            System.out.println("\u001B[31m"+ " Combustivel insuficiente para dirigir "+ distancia + " km, você é um liso de combustivel" + "\u001B[0m");
    }

    public double previsaoDeAutonomia(){
        return combustivelNoTanque * consumoPorKm;
    }
}
