package Entidades;

public class Produto extends _EntidadesBases {
    private String nome;
    private double preco;

    public Produto() {
    }

    public Produto(int id, String nome, double preco) {
        super(id);
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                "} " + super.toString();
    }
}
