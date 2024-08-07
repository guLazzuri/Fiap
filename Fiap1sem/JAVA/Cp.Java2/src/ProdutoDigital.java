import java.awt.*;
import java.util.List;

public class ProdutoDigital extends Produto{
    private String tipoDeArquivo;
    private int tamanhDoArquivo;


    public ProdutoDigital(String nome, String descricao, double preco, List imagens, String tipoDeArquivo, int tamanhDoArquivo) {
        super(nome, descricao, preco, imagens);
        this.tipoDeArquivo = tipoDeArquivo;
        this.tamanhDoArquivo = tamanhDoArquivo;
    }
}
