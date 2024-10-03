package Model;

import java.util.List;

public class Conserto {
    private String nome;
    private String descricao;
    private List<Veiculos> veiculos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Veiculos> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculos> veiculos) {
        this.veiculos = veiculos;

    }

    public void adicionarVeiculo(Veiculos veiculo) {
        System.out.println("Veiculo adicionado com sucesso!");
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculos veiculo) {
        System.out.println("Veiculo removido com sucesso!");
        veiculos.remove(veiculo);
    }

    public void listarVeiculos() {
        for (Veiculos veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }


}
