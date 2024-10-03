package Entidade;

public class Servico extends EntidadeBase {
    private String descricao;
    private double preco;
    private double duracaoEstimadas;
    private int idCarro;

    public Servico(int id, String descricao, double preco, double duracaoEstimadas, int idCarro) {
        super(id);
        this.descricao = descricao;
        this.preco = preco;
        this.duracaoEstimadas = duracaoEstimadas;
        this.idCarro = idCarro;
    }

    // Getters and Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getDuracaoEstimadas() {
        return duracaoEstimadas;
    }

    public void setDuracaoEstimadas(double duracaoEstimadas) {
        this.duracaoEstimadas = duracaoEstimadas;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }
}
