package Model;

import java.util.ArrayList;
import java.util.List;

public class Oficina {
    private String donoDoCarro;
    private String modeloCarro;
    private int anoFabricacao;
    private List<Veiculos> veiculosList;

    public Oficina() {
        this.veiculosList = new ArrayList<>();
    }

    public String getDonoDoCarro() {
        return donoDoCarro;
    }

    public void setDonoDoCarro(String donoDoCarro) {
        this.donoDoCarro = donoDoCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public List<Veiculos> getVeiculosList() {
        return veiculosList;
    }

    public void setVeiculosList(List<Veiculos> veiculosList) {
        this.veiculosList = veiculosList;
    }

    public void adicionarVeiculoNaOficina(Veiculos veiculo) {
        this.veiculosList.add(veiculo);
        System.out.println("Veículo adicionado à oficina: " + veiculo.getModelo() + " " + veiculo.getModelo());
    }

    public void mostrarVeiculoNaOficina() {
        System.out.println("Veículos na oficina:");
        for (Veiculos veiculo : veiculosList) {
            System.out.println(veiculo.getMarca() + " " + veiculo.getModelo());
        }
    }

    public void removerVeiculoDaOficina(Veiculos veiculo) {
        veiculosList.remove(veiculo);
        System.out.println("Veículo removido da oficina: " + veiculo.getMarca() + " " + veiculo.getModelo());
    }
}
