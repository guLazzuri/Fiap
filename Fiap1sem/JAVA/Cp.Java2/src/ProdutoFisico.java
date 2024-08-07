import java.util.List;

public class ProdutoFisico extends Produto {
    private double pesoEmGramas;
    private double dimensao;

    public ProdutoFisico(String nome, String descricao, double preco, List imagens, double pesoEmGramas, double dimensao) {
        super(nome, descricao, preco, imagens);
        this.pesoEmGramas = pesoEmGramas;
        this.dimensao = dimensao;
    }
}
