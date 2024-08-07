import java.util.List;
import java.util.stream.Collectors;

public class ImagemProduto {
    private List<String> urlImagem;

    public void AdicionarImagem(ImagemProduto urlImagem) {
        urlImagem.add(urlImagem);
    }

    private void add(ImagemProduto urlImagem) {
    }

    public void RemoverImagem(ImagemProduto urlImagem) {
        urlImagem.remove(urlImagem);
    }

    private void remove(ImagemProduto urlImagem) {
    }


    public List<String> listarImagensPorImagens(String imagens) {
        return urlImagem.stream()
                .filter(v -> v.getClass().equals(imagens))
                .collect(Collectors.toList());
    }

}
