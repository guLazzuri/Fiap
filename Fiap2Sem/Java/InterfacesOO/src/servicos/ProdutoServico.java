package servicos;

import entidades.Produto;
import repositorios.ProdutoRepositorio;

public class ProdutoServico {
    ProdutoRepositorio produtoRepositorio;

    public ProdutoServico() {
        this.produtoRepositorio =  new ProdutoRepositorio();
    }

    public void cadastrar(Produto produto){
        var produtoValido = validarProduto(produto);
        if(produtoValido){
            produtoRepositorio.cadastrar(produto);
            System.out.println("Produto cadastrado com sucesso");
        }
    }
    public Produto buscarPorID(int id){
        var produto = produtoRepositorio.buscarPorID(id);
        if(produto==null){
            System.out.println("Produto não foi encontrado");
        }
        return produto;
    }

    private boolean validarProduto(Produto produto){
        if(produto.getPreco()<0){
            System.out.println("Preco negativo inválido");
            return false;
        }
        return true;
    }
}
