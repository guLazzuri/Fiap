package manipulacaoDeListas;

import bgg.Boardgame;

import java.util.ArrayList;
import java.util.Arrays;

public class Exemplo {
    public static void testar(){
        var jogosSerieProjectL = new ArrayList<Boardgame>();

        var jogoPrincipal = new Boardgame("Project L",
                2020, 1, 4,
                3, 45, 8,
                new ArrayList<>());
        var primeiraExpansao = new Boardgame("Project L: Finesse",
                2021, 1,
                4, 3, 45,
                8, new ArrayList<>());
        var segundaExpansao = new Boardgame("Project L: Research",
                2021, 1,
                4, 3, 45,
                8, new ArrayList<>());

        jogosSerieProjectL.add(jogoPrincipal);
        jogosSerieProjectL.add(primeiraExpansao);
        jogosSerieProjectL.add(segundaExpansao);

        // manipulação de strings
        var nome = "Project L: Ghost piece         ";
        // o split é um método que divide uma string em partes
        var partes = nome.split(":");
        System.out.println(Arrays.toString(partes));
        // o trim é um método que remove espaços em branco no início e no final de uma string
        System.out.println(nome.trim());
        // o substring é um método que retorna uma parte da string
        System.out.println(nome.substring(0,5));
        // o replace é um método que substitui uma parte da string por outra
        System.out.println(nome.replace("Ghost piece", "Finesse"));
        // o toLowerCase é um método que transforma a string em minúsculas
        System.out.println(nome.toLowerCase());
        // o toUpperCase é um método que transforma a string em maiúsculas
        System.out.println(nome.toUpperCase());

        // manipulação de listas com stream api
        var numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // o stream() é um método de Listas que significa que vamos manipular os elementos da lista
        // o filter é um método que filtra os elementos da lista
        var numerosPares = numeros.stream().filter(numero -> numero % 2 == 0).toList();
        System.out.println(numerosPares);
        // o map é um método que transforma os elementos da lista em outros elementos
        var quadrados = numeros.stream().map(numero -> numero * numero).toList();
        System.out.println(quadrados);
        // o reduce é um método que combina os elementos da lista em um único elemento
        var soma = numeros.stream().reduce(0, Integer::sum);
        System.out.println(soma);
        soma = numeros.stream().mapToInt(Integer::intValue).sum();
        System.out.println(soma);
        var average = numeros.stream().mapToInt(Integer::intValue).average();
        System.out.println(average.orElse(0));
        // o forEach é um método que executa uma ação para cada elemento da lista
        numeros.forEach(numero -> System.out.println("numero: " + numero));
        // o size é um método que retorna o tamanho da lista
        System.out.println(numeros.size());
    }

    public static void printJogosSerieProjectL(ArrayList<Boardgame> jogosSerieProjectL) {
        //apresentar só as expansões
        System.out.println("Expansões da série Project L: " +
                //jogosSerieProjectL.subList(1, jogosSerieProjectL.size()));
                Arrays.toString(jogosSerieProjectL.stream().filter(jogo -> jogo.getName()
                        .contains(":")).toArray()));
        // só apresentar a string de expansões

        jogosSerieProjectL
                // o stream() é um método de Listas que significa que vamos manipular os elementos da lista
                .stream()
                // o filter é um método que filtra os elementos da lista
                // o parametro jogo -> jogo é uma função lambda que recebe o item da lista e retorna um booleano
                // neste caso, estamos filtrando os jogos que contém ":" no nome
                .filter(jogo -> jogo.getName()
                        // o contains é um método que verifica se a string contém outra string
                        .contains(":"))
                // o map é um método que transforma os elementos da lista em outros elementos
                // no caso, estamos transformando os jogos em uma lista de strings
                .map(boardgame -> boardgame
                        .getName()
                        // o split é um método que divide uma string em partes
                        .split(":")[1])
                // o forEach é um método que executa uma ação para cada elemento da lista
                .toList()
                .forEach(System.out::println);
    }
}
