package models;

import java.util.ArrayList;
import java.util.List;

public class Frota {
    //Atributos da classe Frota
    private String nome;
    private List<Veiculo> veiculos;

    // Construtor vazio, que inicializa a lista de veículos, mais nada, que é utilizado
    // quando não tem nenhum veiculo ex: Frota f = new Frota();
    public Frota(){
        veiculos = new ArrayList<>();
    }

    // Construtor completo, que inicializa o nome da frota e a lista de veículos
    // ex: Frota f = new Frota("Frota 1", veiculos);"
    public Frota(String nome, List<Veiculo> veiculos) {
        this.nome = nome;
        this.veiculos = veiculos;
    }

    //Getters e Setters, que são métodos que permitem acessar e modificar os atributos
    // veiculos só tem get porque não é interessante modificar a lista de veículos,
    // o ideal é que a gente adicione ou remova veículos através de métodos específicos
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    //métodos específicos para adicionar e remover veículos da frota
    public void adicionarVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
}
