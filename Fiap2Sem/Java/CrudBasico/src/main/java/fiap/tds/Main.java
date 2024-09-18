package fiap.tds;

import fiap.tds.entities.Produto;
import fiap.tds.repositories.ProdutoRespositorio;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fazendo insert no oracle");

        var produtoRespositorio = new ProdutoRespositorio();

        //var produto = new Produto(0, "Sprite", 5.5);
        //produtoRespositorio.Insert(produto);

        var produtos = produtoRespositorio.GetAll();
        //produtos.forEach(System.out::println);

        var produto = produtoRespositorio.GetById(1);
       // System.out.println(produto);

        produtos = produtoRespositorio.GetByName("Spr");
        produtos.forEach(System.out::println);
        produtoRespositorio.Delete(42);

        produtoRespositorio.Update(new Produto(1, "Coca-Cola 500ml", 5.5), 1);
    }
}