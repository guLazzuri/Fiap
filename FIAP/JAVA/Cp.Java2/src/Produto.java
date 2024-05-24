import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private List<String> imagens;

    public Produto(String nome, String descricao, double preco, List<String> imagens){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagens = imagens;
    }

    public void ExibirDetalhes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Preço: " + this.preco);
        System.out.println("Imagem: " + this.imagens);
    }

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public void addImagem(String imagem) {
        imagens.add(imagem);
    }

    public void removeImagem(String imagem) {
        imagens.remove(imagem);
    }
    public void AdicionarProduto(Produto produto) {
        produto.add(produto);
    }

}