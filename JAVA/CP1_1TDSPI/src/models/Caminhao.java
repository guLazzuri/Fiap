package models;

public class Caminhao extends Veiculo {
    public static final double CAPACIDADE_POR_EIXO = 15000;
    public static final double EIXOS_MAXIMOS = 9;
    private int eixos;
    private double capacidadeDeCarga;
    private double pesoTotal;

    public Caminhao() {
    }

    public Caminhao(String marca, int ano, double consumoPorKm, String modelo) {
        super(marca, ano, consumoPorKm, modelo);
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos){
        // para valor de i começando em 0, enquanto i for menor que o numero de eixos, incremento i
        // o nome i no for é uma convenção que significa indice, poderia ser qualquer nome
        for(int i = 0; i < eixos; i++)
            adicionarUnidadeDeEixo();
    }

    public double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "eixos=" + eixos +
                ", capacidadeDeCarga=" + capacidadeDeCarga +
                ", pesoTotal=" + pesoTotal +
                "} " + super.toString();
    }

    public void adicionarUnidadeDeEixo(){
        if(eixos >= EIXOS_MAXIMOS){
            System.out.println("O caminhão já atingiu a capacidade máxima de eixos.");
            return;
        }
        eixos++;
        capacidadeDeCarga = eixos * CAPACIDADE_POR_EIXO;
        consumoPorKm = consumoPorKm + (consumoPorKm * 0.1);
    }

    public void removerUnidadeDeEixo(){
        if(eixos <= 0){
            System.out.println("O caminhão não possui eixos.");
            return;
        }
        eixos--;
        capacidadeDeCarga = eixos * CAPACIDADE_POR_EIXO;
        consumoPorKm = consumoPorKm - (consumoPorKm * 0.1);
    }

    public void carregar(double peso) {
        if(peso + pesoTotal > capacidadeDeCarga){
            System.out.println("O caminhão não suporta o peso informado.");
            return;
        }
        pesoTotal += peso;
        consumoPorKm = consumoPorKm + (pesoTotal * 0.0001); // 0.01% de consumo a mais por kg
    }
}
