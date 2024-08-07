import legoland.Avaliacao;
import legoland.produto;

import java.util.ArrayList;
import java.util.Arrays;

//Nesse código a ideia inicial era que as classes conversassem entre si printando os resultados na tela sobre avaliação e categoria de produto, mas acabei não conseguindo terminar a tempo.(classe main, produto e avaliação são as mais completas):/
public class Main {
    public static void main(String[] args) {
        legoTeste();
    }

    public static void legoTeste() {
        var produto = new produto("hellokitty", 2024,"super fofa", 200,9,
                new ArrayList<Avaliacao>(Arrays.asList(
                        new Avaliacao("usuario1", 8, "bom brinquedo"),
                        new Avaliacao("usuario2", 4, "mais ou menos"),
                        new Avaliacao("usuario3", 1, "pessimo brinquedo, uma bela bosta"),
                        new Avaliacao("usuario4", 4, "é até que OK")
                )));

        System.out.println(produto.getRatings()
                .stream()
                .mapToDouble(Avaliacao::getAvaliacao)
                .average()
                .orElse(0));


        // remover palavrões dos comentários
        produto.getRatings().stream()
                .map(rating -> rating.getComentario()
                        .replace("merda", "%#$%#")).forEach(System.out::println);

        //avaliações com mais de 5
        produto.getRatings().stream().filter(nota -> nota.getAvaliacao() > 5).forEach(System.out::println);

        //contar as avaliações que tiveram nota menor 5
        System.out.println(produto.getRatings().stream().filter(nota -> nota.getAvaliacao() == 5).count());
        }
    }