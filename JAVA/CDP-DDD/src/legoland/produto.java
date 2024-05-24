package legoland;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class produto {
    private String nome;
    private String descricao;
    private double valor;
    private int anoLancamento;
    private double meanAvaliacoes;
    private List<Avaliacao> avaliacoes;

    public produto() {
    }

    public produto(String nome, int anoLancamento, String descricao, double valor, double meanAvaliacoes,
                   List<Avaliacao> avaliacoes) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.descricao = descricao;
        this.valor = valor;
        this.meanAvaliacoes = calculateMeanAvaliacoes();
    }

    private double calculateMeanAvaliacoes() {
        return avaliacoes.stream()
                .mapToDouble(Avaliacao::getAvaliacao)
                .average()
                .orElse(0);
    }


    private double calculateMeanRatings() {
        return avaliacoes.stream()
                .mapToDouble(Avaliacao::getAvaliacao)
                .average()
                .orElse(0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double valor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMeanAvaliacoes() {
        return meanAvaliacoes;
    }

    public void setMeanAvaliacoes(double meanAvaliacoes) {
        this.meanAvaliacoes = meanAvaliacoes;
    }

    public List<Avaliacao> getRatings() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", descricao=" + descricao +
                ", valor=" + valor +
                ", meanAvaliacoes=" + meanAvaliacoes +
                ", avaliacoes=" + avaliacoes +
                '}';

    }
}

